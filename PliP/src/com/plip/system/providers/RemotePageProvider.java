package com.plip.system.providers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.plip.exceptions.persistence.NoPageRecievedException;
import com.plip.exceptions.persistence.NullModelAttributesException;
import com.plip.exceptions.persistence.PageNotFoundException;
import com.plip.exceptions.persistence.ProductNotFoundException;
import com.plip.persistence.daos.impls.OrderDaoImpl;
import com.plip.persistence.daos.impls.PageDaoImpl;
import com.plip.persistence.daos.impls.PageProductDaoImpl;
import com.plip.persistence.daos.impls.ProductDaoImpl;
import com.plip.persistence.daos.interfaces.OrderDao;
import com.plip.persistence.daos.interfaces.PageDao;
import com.plip.persistence.daos.interfaces.PageProductDao;
import com.plip.persistence.daos.interfaces.ProductDao;
import com.plip.persistence.model.Order;
import com.plip.persistence.model.Page;
import com.plip.persistence.model.PageProduct;
import com.plip.persistence.model.Product;
import com.plip.system.communication.WebServiceManager;
import com.plip.system.config.SystemUtils;

public class RemotePageProvider implements PageProvider{

	@Override
	public Page getLastPage() throws NoPageRecievedException,
			PageNotFoundException {
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("date", String.valueOf(new Date())));
			
		WebServiceManager wsManager = new WebServiceManager(urlParameters); 
		wsManager.setUrl(new SystemUtils().getParam("DusaServer"));
//		Thread myThread = new Thread(wsManager);
//		myThread.start(); 
		PageDao pageDao = new PageDaoImpl();
		JSONObject response = wsManager.getResponse();
		JSONObject order = null;
		JSONArray pageProducts = null;
		try {
			order = response.getJSONObject("order");
			pageProducts = response.getJSONArray("page_products");
			

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page page = addPageWithProducts(pageProducts);
		Order orderModel = addOrder(order);
		page.setOrder(orderModel);
		try{
			pageDao.addPage(page);	
			}catch(NullModelAttributesException e){
			e.printStackTrace();	
			}
		return page;
	}
	
	public Order addOrder(JSONObject jsonOrder){
		OrderDao orderDao = new OrderDaoImpl();
		Order order = new Order();
		try {
			order.setCode(jsonOrder.getString("code"));
			order.setClient(jsonOrder.getString("client"));
			order.setInsertDate(new Date());
			orderDao.addOrder(order);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullModelAttributesException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public Page addPageWithProducts(JSONArray jsonPageProducts){
		ProductDao productDao =  new ProductDaoImpl();
		Product product = new Product();
		
	
		Page page = new Page();
		Set<PageProduct> pageProductsSet = new HashSet<PageProduct>();
//		try{
//		pageDao.addPage(page);	
//		}catch(NullModelAttributesException e){
//		e.printStackTrace();	
//		}
		for (int i = 0 ; i < jsonPageProducts.length() ; i ++){
			JSONObject jsonObject;
			try {
				jsonObject = jsonPageProducts.getJSONObject(i);
				String name = jsonObject.getString("name");
				int code = jsonObject.getInt("code");
				String laboratory = jsonObject.getString("laboratory");
				try{
				product  = productDao.getProductByNameAndCode(name, code);
				
				}catch(ProductNotFoundException e){
					product.setCode(code);
					product.setName(name);
					product.setDescription(name);
					product.setEnabled(true);
					product.setLaboratory(laboratory);
					try {
						productDao.addProduct(product);
					} catch (NullModelAttributesException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PageProduct pageProduct = new PageProduct();
			pageProduct.setProduct(product);
			pageProduct.setPage(page);
//			try{
//				pageProductDao.addPageProduct(pageProduct);
				pageProductsSet.add(pageProduct);
//			}catch(NullModelAttributesException e){
//				e.printStackTrace();
//			}
			
		    
		}
		page.setPageProducts(pageProductsSet);
		return page;
	
	}

}
