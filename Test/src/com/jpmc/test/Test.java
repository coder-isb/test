package com.jpmc.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.jpmc.dto.Message;
import com.jpmc.dto.MessageType;
import com.jpmc.dto.Sale;
import com.jpmc.exceptions.MessageExceptions;
import com.jpmc.util.MessageProcessor;
import com.jpmc.util.SalesBook;

public class Test {

	public static void main(String[] args) {
		
		
		Sale sale1 = new Sale(new BigDecimal(5), "Apple", 1);
		//sale1.setPrice(new BigDecimal(5));
		//sale1.setProductType("Apple");
		
		Message message1 = new Message(sale1, MessageType.MESSAGE_TYPE_1);
		
		
		Sale sale2 = new Sale(new BigDecimal(5), "Oranges", 4);
		
		//sale2.setPrice(new BigDecimal(8));
		//sale2.setProductType("Oranges");
		
		Message message2 = new Message(sale2, MessageType.MESSAGE_TYPE_2);
		
		Sale sale3 = new Sale(new BigDecimal(15), "Grapes", 100);
		
		//sale3.setPrice(new BigDecimal(88));
		//sale3.setProductType("Grapes");
		
		Message message3 = new Message(sale1, MessageType.MESSAGE_TYPE_3);
		message3.setOperationValue(new BigDecimal(2));
		message3.setOperation('+');
		
		ArrayList<Message> messages = new ArrayList<>();
		//messages.add(message1);
		//messages.add(message2);
		
		// Creating Sample Data
		
		for(int i=0; i< 100; i++){
			
			Message message11 = new Message(sale1, MessageType.MESSAGE_TYPE_1);
			messages.add(message11);
			//System.out.println(message2.getNumberOfSales());
			messages.add(message2);
			messages.add(message3);
		}
		
		int batchSizeReportLog=10;
		int batchSizeAdjustmentLog=50;
		
		
		for(int i = 1; i <= messages.size(); i++){
			
			//System.out.println("Processing Message: " +i);
			
			try {
				MessageProcessor.processMessage(messages.get(i-1));
			} catch (MessageExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i>0 && i % batchSizeReportLog == 0){
				//System.out.println("Batch Size 10");
				SalesBook.INSTANCE.logSaleReports();
			}
			if(i>0 && i % batchSizeAdjustmentLog == 0){
				//System.out.println("Batch Size 500000");
				System.out.println("###### Application Is Pausing.... #######");
				SalesBook.INSTANCE.logSaleAdjustments();
				break;
			}
			
		}
		
	}

}
