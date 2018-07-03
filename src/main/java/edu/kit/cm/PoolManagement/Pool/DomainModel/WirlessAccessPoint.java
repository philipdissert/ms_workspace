package edu.kit.cm.PoolManagement.Pool.DomainModel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class WirlessAccessPoint extends PoolElement {
	
	private List<MobileDevice> devices; 

	public WirlessAccessPoint(int id) {
		super(id, "wap");
	}
	
}
