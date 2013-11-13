package com.google.hacatone.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.google.hacatone.entity.Event;
import com.google.hacatone.entity.Favorite;
import com.google.hacatone.entity.Food;
import com.google.hacatone.entity.FoodType;
import com.google.hacatone.entity.Gallery;
import com.google.hacatone.entity.GalleryType;
import com.google.hacatone.entity.Grape;
import com.google.hacatone.entity.Hotel;
import com.google.hacatone.entity.Restaurants;
import com.google.hacatone.entity.Shop;
import com.google.hacatone.entity.WineBarCode;
import com.google.hacatone.entity.WineFoodPairing;
import com.google.hacatone.entity.WineType;
import com.google.hacatone.entity.Wines;
import com.google.hacatone.query.FoodTypeResponce;


public class HacatoneDaoImpl{
	private Session sessionFactory;

	public HacatoneDaoImpl(Session sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void setSessionFactory(Session sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Wines> getGeorgianGrapes(){
	//	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(GeorgianGrapes.class);
		GrapesListImpl gl = new GrapesListImpl();
		sessionFactory.doWork(gl);
		return gl.getList();
//		Query query = sessionFactory.getCurrentSession().createQuery("from GeorgianGrapes");
//		return query.list();
	}
	public Wines getWineDetails(int id){
		WineDetails gl = new WineDetails(id);
		sessionFactory.doWork(gl);
		return gl.getWine();
	}
	public List<Favorite> getFavorite(){
		Criteria criteria = sessionFactory.createCriteria(Favorite.class);
		return criteria.list();
	}
	public List<Gallery> getGallery(){
		Criteria criteria = sessionFactory.createCriteria(Gallery.class);
		return criteria.list();
	}
	public List<GalleryType> getGalleryType(){
		Criteria criteria = sessionFactory.createCriteria(GalleryType.class);
		return criteria.list();
	}
	public List<Hotel> getHotel(){
		Criteria criteria = sessionFactory.createCriteria(Hotel.class);
		return criteria.list();
	}
	public List<Restaurants> getReqstaurant(){
		Criteria criteria = sessionFactory.createCriteria(Restaurants.class);
		return criteria.list();
	}
	public List<Shop> getShop(){
		Criteria criteria = sessionFactory.createCriteria(Shop.class);
		return criteria.list();
	}
	public List<Food> getFood(){
		Criteria criteria = sessionFactory.createCriteria(Food.class);
		return criteria.list();
	}
	public List<FoodType> getFoodType(){
		Criteria criteria = sessionFactory.createCriteria(FoodType.class);
		return criteria.list();
	}
	public List<WineType> getWineType(){
		Criteria criteria = sessionFactory.createCriteria(WineType.class);
		return criteria.list();
	}
	public List<WineFoodPairing> getWineFoodPairing(){
		Criteria criteria = sessionFactory.createCriteria(WineFoodPairing.class);
		return criteria.list();
	}
	public List<Event> getEvent(){
		Criteria criteria = sessionFactory.createCriteria(Event.class);
		criteria.addOrder(Order.asc("startDate"));
		return criteria.list();
	}
	public List<Grape> getGrape(){
		Criteria criteria = sessionFactory.createCriteria(Grape.class);
		return criteria.list();
	}
	
	public void getAddToFavorite(Favorite f){
		Transaction tran = sessionFactory.getTransaction();
		tran.begin();
		sessionFactory.save(f);
		tran.commit();
	}
	public List<Wines> getFollowedWhineList(String id){
	//	Criteria criteria = sessionFactory.createCriteria(Favorite.class);
	//	criteria.add(Restrictions.eq("userId", String.valueOf(id)));
		
		@SuppressWarnings("unchecked")
		FavoriteListImpl f = new FavoriteListImpl(id);
		sessionFactory.doWork(f);
		List<Favorite> favList = f.getList();
		GrapesListImpl gl = new GrapesListImpl();
		sessionFactory.doWork(gl);
		List<Wines> vList = gl.getList();
		for (int i = 0; i < vList.size(); i++) {
			for (int j = 0; j < favList.size(); j++) {
				if(vList.get(i).getId()==favList.get(j).getWineId()){
					vList.get(i).setFavorite(true);
				}
			}
		}
		
		return gl.getList();
	}
	public Wines getWineForBarCode(String barcode){
		Wines w=null;
		Criteria criteria = sessionFactory.createCriteria(WineBarCode.class);
		criteria.add(Restrictions.eq("bar_code", barcode));
		WineBarCode wb = (WineBarCode) criteria.uniqueResult();
		if(wb!=null){
			w=getWineDetails(Integer.parseInt(wb.getWine_id()));
		}
		return w;
	}
	@SuppressWarnings("null")
	public List<FoodTypeResponce> getWineFoodPairing(String food){
		List<FoodTypeResponce> list = new ArrayList<FoodTypeResponce>();
		Criteria criteria = sessionFactory.createCriteria(Food.class);
		criteria.add(Restrictions.eq("type_id", Integer.parseInt(food)));
		List<Food> foods = criteria.list();
		for(int i=0;i<foods.size();i++){
			FoodTypeResponce f= new FoodTypeResponce();
			f.setName(foods.get(i).getName());
			f.setThumb(foods.get(i).getThumb());
			
			WineFoodPairingImpl imp = new WineFoodPairingImpl(foods.get(i).getId());
			sessionFactory.doWork(imp);
			String wineNames="";
			List<WineFoodPairing> l =imp.getWine();
				for(int j=0;j<l.size();j++){
					Wines wine = getWineDetails(l.get(j).getWineTypeId());
					wineNames +=wine.getName()+", ";
				}
				if(!wineNames.isEmpty()){
					f.setWineName(wineNames.substring(0, wineNames.length()-2));
				}
			list.add(f);
		}
		return list;
	}
	
}