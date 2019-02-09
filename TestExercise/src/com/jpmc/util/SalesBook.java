package com.jpmc.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmc.dto.Sale;
import com.jpmc.dto.SaleAdjustment;

public enum SalesBook {

	INSTANCE;

	int totalSalesRecordedCount;
	BigDecimal totalAmountForSales;

	Map<String, List<Sale>> allSales = new HashMap<>();

	Map<String, List<SaleAdjustment>> allAdjustments = new HashMap<>();

	public void recordSale(Sale sale) {

		if (allSales.containsKey(sale.getProductType())) {
			List<Sale> sales = allSales.get(sale.getProductType());
			sales.add(sale);
		} else {
			List<Sale> sales = new ArrayList<>();
			sales.add(sale);
			allSales.put(sale.getProductType(), sales);
		}
	}

	public void recordAdjustments(SaleAdjustment saleAdjustment) {

		if (allAdjustments.containsKey(saleAdjustment.getSale()
				.getProductType())) {
			List<SaleAdjustment> adjustments = allAdjustments
					.get(saleAdjustment.getSale().getProductType());
			adjustments.add(saleAdjustment);
		} else {
			List<SaleAdjustment> sales = new ArrayList<>();
			sales.add(saleAdjustment);
			allAdjustments.put(saleAdjustment.getSale().getProductType(), sales);
		}
	}

	public void applyAdjustment(String productType, BigDecimal operationValue, char operation){

		if(allSales.size()>0){
			List<Sale> sales = allSales.get(productType);
			//System.out.println(sales.size());

			for(Sale s: sales){
				if( operation == '+'){
					s.setPrice(s.getPrice().add(operationValue));
				}else if(operation == '-'){
					s.setPrice(s.getPrice().subtract(operationValue));
				}else if(operation == '*'){
					s.setPrice(s.getPrice().multiply(operationValue));
				}
			}
		}
	}

	public void logSaleReports(){


		if(allSales.size()>0){

			for (String key : allSales.keySet()) {

				//System.out.println(key);

				List<Sale> sales = allSales.get(key);

				BigDecimal totalPrice = new BigDecimal(0);

				for(Sale s:sales){  
					//System.out.println(s.getPrice()); 
					totalPrice = totalPrice.add(s.getPrice());
				} 

				System.out.println("Product Type : "+key + " Quantity :" + sales.size() + " Total Price : " + totalPrice);


			}

		}

	}

	public void logSaleAdjustments(){

		if(allAdjustments.size()>0){

			for (String key : allAdjustments.keySet()) {

				List<SaleAdjustment> adjustments = allAdjustments.get(key);

				for(SaleAdjustment adjustment:adjustments){  

					System.out.println("Product Type : "+key + " Adjustment Operation : "+adjustment.getOperation() +" Adjustment Amount : "+ adjustment.getAmount() );

				} 
			}

		}

	}

}
