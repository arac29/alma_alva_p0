package Hotel.Reservation.service;

import java.util.List;

import HotelReservation.pojos.Guest;
import HotelReservation.pojos.Room;
import HotelReservation.pojos.Room.RoomType;



public class GuestServiceImpl implements GuestService {
	private CustomCacheService<Guest> guestCache = new CustomCacheServiceSimpleInMemory<Guest>();
	
	public void setGuestCache(CustomCacheService<Guest> guestCache) {
		this.guestCache=guestCache;
	}
	public GuestServiceImpl(CustomCacheService<Guest> guestCache) {
		super();
		this.guestCache = guestCache;
	}
	
	// USE MOCKito ? inject that mock into guestserviceImpl  the cache service and write test  
	// add mochito as a dependency
	public GuestServiceImpl() {
		
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Guest createGuest(String name, String phoneNumber, double payment, Room room) {
		Guest newGuest = new Guest(name, room, phoneNumber, payment);
		guestCache.addToCache(newGuest);
		return newGuest;
	}


	@Override
	public void addGuestToList(Guest guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkOutGuest(Guest guest) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Guest> getAllGuests() {
		return guestCache.retrieveAllItems();
	}


}
