package com.google.hacatone.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.google.hacatone.dao.HacatoneDaoImpl;
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
import com.google.hacatone.entity.WineFoodPairing;
import com.google.hacatone.entity.WineType;
import com.google.hacatone.entity.Wines;
import com.google.hacatone.query.FavoriteRequest;
import com.google.hacatone.query.FoodTypeResponce;

@Path("/hacatone")
public class HacatoneWebService {
	@GET
	@Path("/getWines")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getGeorgianGrapes() {
		List<Wines> list = getDao().getGeorgianGrapes();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getFavorite")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getFavorite() {
		List<Favorite> list = getDao().getFavorite();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getGallery")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getGallery() {
		List<Gallery> list = getDao().getGallery();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getGalleryType")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getGalleryType() {
		List<GalleryType> list = getDao().getGalleryType();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getHotel")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getHotel() {
		List<Hotel> list = getDao().getHotel();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getReqstaurant")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getReqstaurant() {
		List<Restaurants> list = getDao().getReqstaurant();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getShop")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getShop() {
		List<Shop> list = getDao().getShop();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getFood")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getFood() {
		List<Food> list = getDao().getFood();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getFoodType")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getFoodType() {
		List<FoodType> list = getDao().getFoodType();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getWineType")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getWineType() {
		List<WineType> list = getDao().getWineType();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getWineFoodPairing")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getWineFoodPairing() {
		List<WineFoodPairing> list = getDao().getWineFoodPairing();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getWineDetails")
	public Response getWineDetails(@QueryParam("id") int id) {
		Wines wine = getDao().getWineDetails(id);
	    String html = "<html><body><p><img src='"+ wine.getImg() +"' width='50' height='50'/>"+ wine.getDescription()+"</p></body></html>";
		return  Response.ok(html, MediaType.TEXT_HTML+ ";charset=utf-8").build();
	}
	@GET
	@Path("/getEvent")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getEvent() {
		List<Event> list = getDao().getEvent();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@GET
	@Path("/getGrape")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response getGrape() {
		List<Grape> list = getDao().getGrape();
		Result result = new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
	@POST
	@Path("/addToFavorite")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response addToFavorite(FavoriteRequest favorite) {
		Response res;
		try{
 		Favorite fav = new Favorite(favorite.getUserId(),favorite.getWineId(),new Date());
 		getDao().getAddToFavorite(fav);
 		 res= Response.ok("OK", MediaType.APPLICATION_JSON + ";charset=utf-8").build();
		}catch(Exception e){
			res=Response.ok("OK", MediaType.APPLICATION_JSON + ";charset=utf-8").build();;
		}
		return res; 
	}
	@GET
	@Path("/getUserFavorir")
	public Response getUserFavorir(@QueryParam("id") String id) {
		List<Wines> list;
		if(id!=null){
			list = getDao().getFollowedWhineList(id);
		}else{
			list = getDao().getFollowedWhineList("");
		}
		Result res = new Result(list);
		return  Response.ok(res, MediaType.APPLICATION_JSON+ ";charset=utf-8").build();
	}
	@GET
	@Path("/getWineForBarCode")
	public Response getWineForBArCode(@QueryParam("barcode") String barcode) {
		Wines wine = getDao().getWineForBarCode(barcode);
		return  Response.ok(wine, MediaType.APPLICATION_JSON+ ";charset=utf-8").build();
	}
	
	@GET
	@Path("/WineFood")
	public Response getWineFoodPairing(@QueryParam("foodid") String foodId) {
		List<FoodTypeResponce> list = new ArrayList<FoodTypeResponce>();
		FoodTypeResponce res = null;
		if(foodId!=null){
			list = getDao().getWineFoodPairing(foodId);
		}
		Result result= new Result(list);
		return  Response.ok(result, MediaType.APPLICATION_JSON+ ";charset=utf-8").build();
	}
	public HacatoneDaoImpl getDao() {
		return new HacatoneDaoImpl(getSessionFactory());
	}

	public Session getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
		Session sess = null;       
		   try {         
		       sess = sessionFactory.getCurrentSession();  
		   } catch (org.hibernate.HibernateException he) {  
		       sess = sessionFactory.openSession();     
		   }             
		   return sess; 
	}
}