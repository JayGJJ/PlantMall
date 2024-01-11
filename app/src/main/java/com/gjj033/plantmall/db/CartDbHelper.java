package com.gjj033.plantmall.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.gjj033.plantmall.entity.CartInfo;

import java.util.ArrayList;
import java.util.List;

public class CartDbHelper extends SQLiteOpenHelper {
    private static CartDbHelper sHelper;
    private static final String DB_NAME = "cart.db";   //数据库名
    private static final int VERSION = 1;    //版本号

    //必须实现其中一个构方法
    public CartDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建单例，供使用调用该类里面的的增删改查的方法
    public synchronized static CartDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new CartDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建cart_table表
        db.execSQL("create table cart_table(_id integer primary key autoincrement, " +
                "username text," +       //用户名
                "plantId integer," +      //商品ID
                "plantName text," +    //商品名称
                "plantNotice text," +    //商品描述
                "plantPrice integer," +   //商品价格
                "plantImg integer," +   //商品图片
                "plantCount integer" +   //商品数量
                ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    添加商品到购物车
    public int addCart(String username, int plantId,String plantName, String plantNotice, int plantPrice, int plantImg) {
        //判断是否添加过商品，如果添加过，就修改数量，如果没有添加过，就添加商品到购物车
        CartInfo addCart = isAddCart(username, plantId);
        if (addCart == null) {
            //修改数量
            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填充占位符
            values.put("username", username);
            values.put("plantId", plantId);
            values.put("plantName", plantName);
            values.put("plantNotice", plantNotice);
            values.put("plantPrice", plantPrice);
            values.put("plantImg", plantImg);
            values.put("plantCount", 1);

            String nullColumnHack = "values(null,?,?,?,?,?,?,?)";
            //执行
            int insert = (int) db.insert("cart_table", nullColumnHack, values);
            db.close();
            return insert;
        }else {
            return  updatePlant(addCart.getCartId(),addCart);
        }


    }

    /*修改购物车*/
    public int updatePlant(int cartId, CartInfo cartInfo) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("plantCount", cartInfo.getPlantCount()+1);
        // 执行SQL
        int update = db.update("cart_table", values, " _id=?", new String[]{cartId+""});
        // 关闭数据库连接
        db.close();
        return update;
    }

    //减购
    public int subtractUpdatePlant(int cartId, CartInfo cartInfo) {
        if (cartInfo.getPlantCount()>=2){
            //获取SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            // 填充占位符
            ContentValues values = new ContentValues();
            values.put("plantCount", cartInfo.getPlantCount()-1);
            // 执行SQL
            int update = db.update("cart_table", values, " _id=?", new String[]{cartId+""});
            // 关闭数据库连接
           db.close();
            return update;
        }
        return 0;
    }

    /*根据用户名和商品ID判断有没有添加过商品到购物车*/
    @SuppressLint("Range")
    public CartInfo isAddCart(String username,int plantId) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        CartInfo cartInfo = null;
        String sql = "select _id,username,plantId,plantName,plantNotice,plantPrice,plantImg,plantCount  from cart_table where username=? and plantId=?";
        String[] selectionArgs = {username,plantId+""};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int cartId = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            int plant_Id = cursor.getInt(cursor.getColumnIndex("plantId"));
            String plant_Name = cursor.getString(cursor.getColumnIndex("plantName"));
            String plant_Notice = cursor.getString(cursor.getColumnIndex("plantNotice"));
            int plant_Price = cursor.getInt(cursor.getColumnIndex("plantPrice"));
            int plant_Img = cursor.getInt(cursor.getColumnIndex("plantImg"));
            int plant_Count = cursor.getInt(cursor.getColumnIndex("plantCount"));
            cartInfo = new CartInfo(cartId,name,plant_Id,plant_Name,plant_Notice,plant_Price,plant_Img,plant_Count);
        }
        cursor.close();
        db.close();
        return cartInfo;
    }

    /*根据用户名查询购物车*/
    @SuppressLint("Range")
    public List<CartInfo> queryCartList(String username) {
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getReadableDatabase();
        List<CartInfo> list = new ArrayList<>();
        String sql = "select _id,username,plantId,plantName,plantNotice,plantPrice,plantImg,plantCount  from cart_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            int cartId = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            int plant_Id = cursor.getInt(cursor.getColumnIndex("plantId"));
            String plant_Name = cursor.getString(cursor.getColumnIndex("plantName"));
            String plant_Notice = cursor.getString(cursor.getColumnIndex("plantNotice"));
            int plant_Price = cursor.getInt(cursor.getColumnIndex("plantPrice"));
            int plant_Img = cursor.getInt(cursor.getColumnIndex("plantImg"));
            int plant_Count = cursor.getInt(cursor.getColumnIndex("plantCount"));
            list.add(new CartInfo(cartId,name,plant_Id,plant_Name,plant_Notice,plant_Price,plant_Img,plant_Count));
        }
        cursor.close();
        db.close();
        return list;
    }

//    删除购物车商品
public int delete(String cartId) {
    //获取SQLiteDatabase实例
    SQLiteDatabase db = getWritableDatabase();
    // 执行SQL
    int delete = db.delete("cart_table", " _id=?", new String[]{cartId});
    // 关闭数据库连接
    db.close();
    return delete;
    }

}
