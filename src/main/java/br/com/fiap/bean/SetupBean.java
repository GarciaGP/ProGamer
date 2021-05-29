package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;
import br.com.fiap.model.Usuario;

// CDI -> CONTEXT DEPENDENCY INJECTION
@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		this.setup.setUsuario((Usuario) context.getExternalContext().getSessionMap().get("user"));
		new SetupDao().save(this.setup);
		System.out.println("Salvando..." + this.setup);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Setup cadastrado!"));
	}
	
	public List<Setup> getSetups(){
		return new SetupDao().getAll();
	}
	
	public List<Setup> getSetupsUsuario(){
		FacesContext context = FacesContext.getCurrentInstance();
		return new SetupDao().getAllUserSetups((Usuario) context.getExternalContext().getSessionMap().get("user"));
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}


}