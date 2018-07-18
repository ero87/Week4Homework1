package com.example.ero.week3homework1;

import com.example.ero.week3homework1.Modeles.Girl;
import com.example.ero.week3homework1.Modeles.MessengeModel;
import com.example.ero.week3homework1.Modeles.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDataProvider {

    public static List<Girl> getListGirl() {
        final List<Girl> list = new ArrayList<>();

        list.add(new Girl("SIRUN", R.drawable.beauti));
        list.add(new Girl("KYANQ", R.drawable.cherylcole));
        list.add(new Girl("ELIZABETH OSLEN", R.drawable.elizabetholsen));
        list.add(new Girl("DZEC", R.drawable.scree595));
        return list;
    }

    static List<UserModel> list = new ArrayList<>();

    public static List<UserModel> getUserList() {

        if (!list.isEmpty()) {
            list.clear();
        }
        list.add(new UserModel("http://p.fod4.com/p/channels/qpztk/profile/ToJNnsiRhmm405cz7CPX_charlize-theron-head-shot.jpg", "Charlize Theron", "age 43","Sexy", "+37498979594", "charlize@mail.ru", new ArrayList<MessengeModel>()));
        list.add(new UserModel("https://i1.wp.com/swaggyimages.com/wp-content/uploads/2018/03/Monica-Bellucci-Iphone-Wallpaper.jpg?fit=499%2C624&ssl=1", "Monica Belucci", "age 54","Love", "+37455559988", "belucci@mail.ru", new ArrayList<MessengeModel>()));
        list.add(new UserModel("https://www.theplace.ru/archive/margot_robbie/img/margot_robbie_focus_movie_photos_2.jpg", "Margo Robbi", "age 28","Joker", "+37499989898", "robbi@mail.ru", new ArrayList<MessengeModel>()));
        list.add(new UserModel("https://www.cosmopolitan.com.hk/var/cosmopolitanhk/storage/images/lifestyle/hollywood-celebrity-elizabetholsen-scarlet-witch-avengers-olsentwins/2048170-1-chi-HK/Elizabeth-Olsen_img_750_h.jpg", "Elizabeth Oslen","age 29", "Beauty", "+37477778899", "elizabet@mail.ru", new ArrayList<MessengeModel>()));
        list.add(new UserModel("https://st.kp.yandex.net/images/actor_iphone/iphone360_21931.jpg", "Jessica Alba","age 37", "Love", "+37477857496", "alba@mail.ru", new ArrayList<MessengeModel>()));
        list.add(new UserModel("https://cdn-img.instyle.com/sites/default/files/styles/684xflex/public/1508780322/102317-kendall-jenner-home-lead.jpg?itok=K5mUJFhd", "Kendall Genner","age 23", "Sexy", "+37477778899", "jener@mail.ru", new ArrayList<MessengeModel>()));
        return list;
    }

    public static UserModel getUserListPosition(int position) {
        return list.get(position);
    }
}
