package newquizeapp.other;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;

import newquizeapp.data.Attempt;

public class Convertor {

    @TypeConverter
    String fromList(List<Attempt> list){
        return new Gson().toJson(list);
    }

    @TypeConverter
    List<Attempt> toList(String json){
        return new Gson().fromJson(json, new TypeToken<List<Attempt>>(){}.getType());
    }


}
