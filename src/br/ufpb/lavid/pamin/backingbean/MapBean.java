package br.ufpb.lavid.pamin.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name="mapBean")
@ViewScoped
public class MapBean implements java.io.Serializable {

	private MapModel model = new DefaultMapModel();;
	
	public MapBean() {
		model = new DefaultMapModel();
		model.addOverlay(new Marker(new LatLng(36.879466,30.667648),"Marker1"));
	}
	
	public MapModel getModel() {
		return this.model;
	}

}
