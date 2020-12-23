package com.daylight.tripservice.trip;

import com.daylight.tripservice.exception.UserNotLoggedInException;
import com.daylight.tripservice.user.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TripServiceTest {

	TripService tripServiceExt = new TripServiceExt();
	User user = new User();

	@Test(expected = UserNotLoggedInException.class)
	public void should_throw_an_exception_when_user_is_not_logged_in() {
		//Setando um login inativo
		tripServiceExt.setActiveLogin(false);
		tripServiceExt.getTripsByUser(user);
	}

	@Test
	public void should_not_return_any_trips_when_users_are_not_friends() {

		//Setando um login ativo
		tripServiceExt.setActiveLogin(true);

		Assert.assertEquals( new ArrayList<Trip>().size(), tripServiceExt.getTripsByUser(user).size());
	}

	@Test
	public void should_return_friend_trips_when_users_are_friend() {

		//Setando um login ativo
		tripServiceExt.setActiveLogin(true);
		user.addFriend(user);
		
		List<Trip> tripList = new ArrayList<Trip>();
		tripList.add(new Trip());

		Assert.assertEquals(tripList, tripServiceExt.getTripsByUser(user));
	}
}
