package edu.kit.cm.PoolManagement.Pool;

import edu.kit.cm.PoolManagement.Parser.PoolParser;
import lombok.Getter;
import lombok.Setter;

public abstract class PoolElement {
	@Getter
	protected int id;
	@Getter @Setter
	protected Location location;
	protected String elementNamen = "pls insert name in subclass";
	
	public String getName() {
		return elementNamen;
	}
	
	public static PoolElement getPoolElement(String name, String parameter) {
		PoolElement output = null;
		switch(PoolParser.parseElementName(name)) {
		case "PC": output = new LearningDesk(PoolParser.parseLocation(parameter), PoolParser.parseId(name), true); break;
		case "Laptop": output = new LearningDesk(PoolParser.parseLocation(parameter), PoolParser.parseId(name), false); break;
		}
		return output;
	}
}
