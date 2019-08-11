package Entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbConnectionHelper extends SQLiteOpenHelper {


    public DbConnectionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase MyDataBase) {

        MyDataBase.execSQL("CREATE TABLE IF NOT EXISTS users (userId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT," +
                "password TEXT, " +
                "totalPoints INTEGER)");

        MyDataBase.execSQL("CREATE TABLE IF NOT EXISTS questions (questionId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "description TEXT," +
                "firstAnswer TEXT," +
                "secondAnswer TEXT," +
                "thirdAnswer TEXT," +
                "fourthAnswer TEXT)");


        MyDataBase.execSQL("INSERT INTO questions VALUES  " +
                "(1, 'How often do you eat animal-based products?','never - vegan','Infrequently - (vegetarian - eggs/dairy, no meat)','Often - (balanced meat/veggies - meat a few times a week, eggs/dairy almost daily)', 'Very often (meat daily)' )," +
                "(2, 'What are you hungry for? How often can you enjoy a vegetarian meal?', 'always', 'frequently','infrequently', 'never')," +
                "(3, 'When you take a coffe, how often do you use reusable cup in the week', 'always', 'frequently', 'infrequently', 'never')," +
                "(4, 'How much of the food that you eat is unprocessed, unpackaged or locally grown?', 'less than 10%', 'between 25% and 50%', '50%', 'more than 75%')");
        //        "(5, 'What percentage of your homes electricity comes from renewable sources?, 'less than 10%', 'between 25% and 50%', '50%', 'more than 75%')"
//                "(6, 'How often do you recicle your trash generated?')," +
//                "(7, 'How many single used plastic have  you use today?')," +
//                "(8, 'How many hours do you fly each year?')," +
//                "(9, 'What kind of transport did you use today? ')," +
//                "(10, 'When you are on a trip which kind of transport do you use?')," +
//                "(11, 'How often do you get involve in Environment petition or join protest for climate change?')
//");



//       MyDataBase.execSQL("CREATE TABLE IF NOT EXISTS answers (answerId INTEGER PRIMARY KEY AUTOINCREMENT," +
//               " answer_desc TEXT," +
//               " points INTEGER," +
//               " question INTEGER)");

//       MyDataBase.execSQL("INSERT INTO answers VALUES " +
//                "(1, 'never - vegan', 15, 1)," +
//               "(2, 'Infrequently - (vegetarian - eggs/dairy, no meat)', 10, 1)," +
//               "(3, 'Often - (balanced meat/veggies - meat a few times a week, eggs/dairy almost daily)', 5, 1)," +
//                "(4, 1, 'Very often (meat daily)', 0, 1)," +
//                "(5, 'always', 15, 2)," +
//               "(6, 'frequently', 10,2)," +
//               "(8, 'never', 0, 2)," +
//                "(10, 'frequently', 10, 3)," +
//                "(11, 'ocassionally', 5, 3)," +
//                "(12, 'Never', 0, 3)," +
//               "(13, 'more than 75%', 15, 4)," +
//                "(14, 'around 50%', 10, 4)," +
//                "(9, 'always', 15, 3)," +
//                "(15, 'less than 25%', 5, 4)," +
//                "(16,'less than 10 %', 0, 4)," +
//                "(19,'less than 25%', 5, 5)," +
//                "(17, 'more than 75%', 15, 5)," +
//                "(18, 'around 50%', 10, 5)," +
//                "(20, 'less than 10 %', 0, 5)," +
//                "(21, 'Always', 15, 6)," +
//                "(22, 'frequently', 10, 6)," +
//               "(23, 'occasionally', 5, 6)," +
//                "(24, 'never', 0, 6)," +
//               "(25, 'None', 15, 7)," +
//                "(26, 'between 1-3 pieces', 10, 7)," +
//                "(27, 'between 3-5 pieces', 5, 7)," +
//                "(28, 'More than 10 pieces', 0, 7)," +
//                "(29, '0', 15, 8)," +
//               "(30, 'between 5 and 15', 10, 8)," +
//                "(31, 'between 15 and 40', 5, 8)," +
//                "(32, 'More than 40', 0, 8)," +
//                "(33, 'walk or bike', 15, 9)," +
//                "(34, 'public transport', 10, 9)," +
//                "(35, 'motorbike', 5, 9)," +
//                "(36, 'car', 0, 9)," +
//                "(37, 'walk or bike', 15, 10)," +
//                "(38, 'public transport', 10, 10)," +
//                "(39, 'taxi', 5, 10)," +
//                "(40, 'rent a car', 0, 10)," +
//                "(41, 'often', 15, 11)," +
//                "(42, 'ocasionally', 10, 11)," +
//                "(43, 'infrequently', 5, 11)," +
//                "(44, 'Never', 0, 11)," +
//                "(7,  'infrequently', 5, 2) ");


//        //MyDataBase.execSQL("create table rounds(roundId int primary key autoincrement, points int, FOREIGN KEY(User) REFERENCES User(userId))");
//
//        //MyDataBase.execSQL("create table score( scoreId int primary key autoincrement, points int, FOREIGN KEY(User) REFERENCES User(userId), FOREIGN KEY(rounds) REFERENCES rounds(roundId), FOREIGN KEY(questions) REFERENCES questions(questionId), FOREIGN KEY(answers) REFERENCES answers(answerId))");
//    }
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        // MyDataBase.execSQL("DROP TABLE IF EXIST User");
        //onCreate(MyDatabase);

    }
}