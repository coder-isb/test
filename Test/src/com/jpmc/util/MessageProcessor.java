package com.jpmc.util;

import com.jpmc.dto.Message;
import com.jpmc.dto.MessageType;
import com.jpmc.dto.SaleAdjustment;
import com.jpmc.exceptions.MessageExceptions;

public class MessageProcessor {

	public static void processMessage(Message message) throws MessageExceptions {

		if (message.getType() == MessageType.MESSAGE_TYPE_1) {
			SalesBook.INSTANCE.recordSale(message.getSale());
		} else if (message.getType() == MessageType.MESSAGE_TYPE_2) {
			for (int i = 0; i < message.getSale().getQuantity(); i++) {
				SalesBook.INSTANCE.recordSale(message.getSale());
			}
		} else if (message.getType() == MessageType.MESSAGE_TYPE_3) {
			SaleAdjustment sd = new SaleAdjustment();
			sd.setAmount(message.getOperationValue());
			sd.setOperation(message.getOperation());
			sd.setSale(message.getSale());
			SalesBook.INSTANCE.recordAdjustments(sd);
			SalesBook.INSTANCE.applyAdjustment(message.getSale().getProductType(),
					message.getOperationValue(), message.getOperation());
		} else {
			throw new MessageExceptions("Unsupported Message Type Received");
		}

	}

}
