package br.inatel.consulta;

import java.rmi.RemoteException;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

public class ConsultaCep {
	
	public Endereco consultar(String cep) {
		AtendeClienteProxy ClienteProxy = new AtendeClienteProxy();
		Endereco ConsultaEndereco = new Endereco();
		
		try {
			br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP endereco = ClienteProxy.consultaCEP(cep);
			
			ConsultaEndereco.cidade = endereco.getCidade();
			ConsultaEndereco.bairro = endereco.getBairro();
			ConsultaEndereco.logradouro = endereco.getEnd();
			ConsultaEndereco.estado = endereco.getUf();
			ConsultaEndereco.complemento = endereco.getComplemento2();
			ConsultaEndereco.cep = endereco.getCep();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (SigepClienteException e) {
			System.out.println(e.getMessage());
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
		
		return ConsultaEndereco;
	}
}
