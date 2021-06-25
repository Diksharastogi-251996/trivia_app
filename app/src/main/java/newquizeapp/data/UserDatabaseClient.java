package newquizeapp.data;

import android.content.Context;

import androidx.room.Room;

public class UserDatabaseClient {

    private static final String DB_NAME = "user_db";
    private static newquizeapp.data.UserDatabase instance;

    public static synchronized newquizeapp.data.UserDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(), newquizeapp.data.UserDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public UserDatabase getUserDatabase() {
        return instance;
    }

}
