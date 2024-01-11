package com.gjj033.plantmall.plantdata;

import android.content.Context;

import com.gjj033.plantmall.R;
import com.gjj033.plantmall.entity.Plant;

import java.util.ArrayList;
import java.util.List;
//处理植物列表数据
public class PlantsListData {
    private List<Plant> plantsList;
    private Context context;

    public PlantsListData(Context context) {
        this.context = context;
    }

    /*初始化植物数据列表*/
    public List<Plant> getPlantsList(int position) {
        List<Plant> plantsList = new ArrayList<>();
        if (position== 0) {
            Plant plant1 = new Plant(101,"魏氏尾萼兰 Masdevallia",context.getString(R.string.orchid),133, R.drawable.masdevallia,"凉","中低","不同","橙色、紫色");
            plantsList.add(plant1);
            Plant plant2 = new Plant(102,"石斛 Love Memory Fizz",context.getString(R.string.fizz),225, R.drawable.fizz,"冷暖","中高","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant2);
            Plant plant3 = new Plant(103,"蝴蝶兰 Butterfly",context.getString(R.string.butterfly),140, R.drawable.butterfly,"冷暖","中等","冬季、春季","黄色、酒红色、橙色、黑色");
            plantsList.add(plant3);
            Plant plant4 = new Plant(104,"萤火虫 Firefly" ,context.getString(R.string.firefly),255, R.drawable.firefly,"中温","中等","秋季、春季","白色、紫色、黄色");
            plantsList.add(plant4);
            Plant plant5 = new Plant(105,"双尾草 Caularthron",context.getString(R.string.caularthron),230, R.drawable.caularthron,"中温","中等","冬季、春季","白色、粉色、橙色");
            plantsList.add(plant5);
            Plant plant6 = new Plant(106,"上颌骨 Maxillaria ",context.getString(R.string.maxillaria),180, R.drawable.maxillaria,"凉","中低","不同","黑色、红色");
            plantsList.add(plant6);
            Plant plant7 = new Plant(107,"文心兰 Oncidium",context.getString(R.string.oncidium),260, R.drawable.oncidium,"凉","中低","秋天， 冬天， 春天","黄色、白色");
            plantsList.add(plant7);
            Plant plant8 = new Plant(108,"霍恩洛希 Anguloa",context.getString(R.string.orchid),350, R.drawable.anguloax,"冷暖","中低","春、夏","黄色、红色");
            plantsList.add(plant8);
        }
        else if (position == 1) {
            Plant plant1 = new Plant(109,"勿忘我 forget-me-not",context.getString(R.string.forgetmenot),50, R.drawable.forgetmenot,"暖","低","春季、夏季","橙色、紫色");
            plantsList.add(plant1);
            Plant plant2 = new Plant(110,"雪滴花 Snowdrop",context.getString(R.string.snowdrop),120, R.drawable.snowdrop,"中温","中等","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant2);
            Plant plant3 = new Plant(111,"大丽花 dahlia",context.getString(R.string.dahlia),40, R.drawable.dahlia,"冷暖","中等","冬季、春季","黄色、酒红色、橙色、黑色");
            plantsList.add(plant3);
            Plant plant4 = new Plant(112,"百合花 lily" ,context.getString(R.string.lily),80, R.drawable.lily,"中温","中等","秋季、春季","白色、紫色、黄色");
            plantsList.add(plant4);
            Plant plant5 = new Plant(113,"石首乌变种 charlesworthii",context.getString(R.string.charlesworthii),60, R.drawable.charlesworthii,"中温","中等","冬季、春季","白色、粉色、橙色");
            plantsList.add(plant5);
            Plant plant6 = new Plant(114,"摩根氏菌 morganii",context.getString(R.string.fizz),225, R.drawable.fizz,"冷暖","中高","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant6);
        }
        else if (position == 2) {
            Plant plant1 = new Plant(101,"魏氏尾萼兰 Masdevallia",context.getString(R.string.orchid),133, R.drawable.masdevallia,"凉","中低","不同","橙色、紫色");
            plantsList.add(plant1);
            Plant plant2 = new Plant(102,"石斛 Love Memory Fizz",context.getString(R.string.fizz),225, R.drawable.fizz,"冷暖","中高","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant2);
            Plant plant3 = new Plant(103,"蝴蝶兰 Butterfly",context.getString(R.string.butterfly),140, R.drawable.butterfly,"冷暖","中等","冬季、春季","黄色、酒红色、橙色、黑色");
            plantsList.add(plant3);
            Plant plant4 = new Plant(104,"萤火虫 Firefly" ,context.getString(R.string.firefly),255, R.drawable.firefly,"中温","中等","秋季、春季","白色、紫色、黄色");
            plantsList.add(plant4);
            Plant plant5 = new Plant(105,"双尾草 Caularthron",context.getString(R.string.caularthron),230, R.drawable.caularthron,"中温","中等","冬季、春季","白色、粉色、橙色");
            plantsList.add(plant5);
            Plant plant6 = new Plant(106,"上颌骨 Maxillaria ",context.getString(R.string.maxillaria),180, R.drawable.maxillaria,"凉","中低","不同","黑色、红色");
            plantsList.add(plant6);
            Plant plant7 = new Plant(107,"文心兰 Oncidium",context.getString(R.string.oncidium),260, R.drawable.oncidium,"凉","中低","秋天， 冬天， 春天","黄色、白色");
            plantsList.add(plant7);
            Plant plant8 = new Plant(108,"霍恩洛希 Anguloa",context.getString(R.string.orchid),350, R.drawable.anguloax,"冷暖","中低","春、夏","黄色、红色");
            plantsList.add(plant8);
        }
        else if (position == 3) {
            Plant plant1 = new Plant(109,"勿忘我 forget-me-not",context.getString(R.string.forgetmenot),50, R.drawable.forgetmenot,"暖","低","春季、夏季","橙色、紫色");
            plantsList.add(plant1);
            Plant plant2 = new Plant(110,"雪滴花 Snowdrop",context.getString(R.string.snowdrop),120, R.drawable.snowdrop,"中温","中等","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant2);
            Plant plant3 = new Plant(111,"大丽花 dahlia",context.getString(R.string.dahlia),40, R.drawable.dahlia,"冷暖","中等","冬季、春季","黄色、酒红色、橙色、黑色");
            plantsList.add(plant3);
            Plant plant4 = new Plant(112,"百合花 lily" ,context.getString(R.string.lily),80, R.drawable.lily,"中温","中等","秋季、春季","白色、紫色、黄色");
            plantsList.add(plant4);
            Plant plant5 = new Plant(113,"石首乌变种 charlesworthii",context.getString(R.string.charlesworthii),60, R.drawable.charlesworthii,"中温","中等","冬季、春季","白色、粉色、橙色");
            plantsList.add(plant5);
            Plant plant6 = new Plant(114,"摩根氏菌 morganii",context.getString(R.string.fizz),225, R.drawable.fizz,"冷暖","中高","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant6);
        }
        else{
            Plant plant1 = new Plant(101,"魏氏尾萼兰 Masdevallia",context.getString(R.string.orchid),133, R.drawable.masdevallia,"凉","中低","不同","橙色、紫色");
            plantsList.add(plant1);
            Plant plant2 = new Plant(102,"石斛 Love Memory Fizz",context.getString(R.string.fizz),225, R.drawable.fizz,"冷暖","中高","冬季、春季、夏季","粉色、紫色、白色");
            plantsList.add(plant2);
            Plant plant3 = new Plant(103,"蝴蝶兰 Butterfly",context.getString(R.string.butterfly),140, R.drawable.butterfly,"冷暖","中等","冬季、春季","黄色、酒红色、橙色、黑色");
            plantsList.add(plant3);
            Plant plant4 = new Plant(104,"萤火虫 Firefly" ,context.getString(R.string.firefly),255, R.drawable.firefly,"中温","中等","秋季、春季","白色、紫色、黄色");
            plantsList.add(plant4);
            Plant plant5 = new Plant(105,"双尾草 Caularthron",context.getString(R.string.caularthron),230, R.drawable.caularthron,"中温","中等","冬季、春季","白色、粉色、橙色");
            plantsList.add(plant5);
            Plant plant6 = new Plant(106,"上颌骨 Maxillaria ",context.getString(R.string.maxillaria),180, R.drawable.maxillaria,"凉","中低","不同","黑色、红色");
            plantsList.add(plant6);
            Plant plant7 = new Plant(107,"文心兰 Oncidium",context.getString(R.string.oncidium),260, R.drawable.oncidium,"凉","中低","秋天， 冬天， 春天","黄色、白色");
            plantsList.add(plant7);
            Plant plant8 = new Plant(108,"霍恩洛希 Anguloa",context.getString(R.string.orchid),350, R.drawable.anguloax,"冷暖","中低","春、夏","黄色、红色");
            plantsList.add(plant8);
        }
        return plantsList;
    }

    public void setPlantsList(List<Plant> plantsList) {
        this.plantsList = plantsList;
    }
}
