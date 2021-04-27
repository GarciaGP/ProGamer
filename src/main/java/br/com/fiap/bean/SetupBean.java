package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@ManagedBean
public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		new SetupDao().save(this.setup);
		System.out.println("Salvando..." + this.setup);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
	}
	
	public List<Setup> getSetups(){
		return new SetupDao().getAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}


}