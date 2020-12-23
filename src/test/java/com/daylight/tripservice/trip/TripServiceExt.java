package com.daylight.tripservice.trip;


import com.daylight.tripservice.user.User;
import com.daylight.tripservice.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripServiceExt extends TripService {

    @Override
    public User getLoggedUser() {
        if (super.isActiveLogin() == true) {
            return new User();
        } else {
            return null;
        }
    }

    @Override
    public List<Trip> findTripsByUser(User user) {
        List<Trip> list = new ArrayList<>();
        list.add(new Trip());
        return list;
    }
}
