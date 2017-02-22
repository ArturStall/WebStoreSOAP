package by.gsu.epamlab.ws;

import javax.jws.WebService;

import by.gsu.epamlab.db.ProductCostDB;

@WebService(endpointInterface = "by.gsu.epamlab.ws.SOAP")
public class SOAPImpl implements SOAP {

	@Override
	public int getCost(int idProduct) {
		return new ProductCostDB().getCostProduct(idProduct);
	}

}