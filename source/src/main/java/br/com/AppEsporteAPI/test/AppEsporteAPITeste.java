package br.com.AppEsporteAPI.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.AppEsporteAPI.model.Bicicleta;
import br.com.AppEsporteAPI.model.Bodyboard;
import br.com.AppEsporteAPI.model.Cliente;
import br.com.AppEsporteAPI.model.ItemVenda;
import br.com.AppEsporteAPI.model.Skate;
import br.com.AppEsporteAPI.model.Venda;
import br.com.AppEsporteAPI.service.VendaService;

public class AppEsporteAPITeste {

	@Autowired
	private static VendaService serviceVenda;

	public static void main(String[] args) {
		// TesteConexao();

		TestePreenchimentoPresistencia();
	}

	private static void TestePreenchimentoPresistencia() {

		Cliente _cliente = new Cliente();
		_cliente.setNome("Felipe");
		_cliente.setDdd(21);
		_cliente.setTelefone(984402668);
		_cliente.setEmail("felipementel@hotmail.com");
		_cliente.setIsativo(true);
		_cliente.setDatacadastro(new Date());

		System.out.printf("toString() Cliente: %s", _cliente);
		System.out.println("");

		Venda _venda = new Venda();

		_venda.setDatavenda(new Date());

		_venda.setCliente(_cliente);

		System.out.printf("toString() Venda: %s", _venda);
		System.out.println("");

		Skate _skate = new Skate();
		_skate.setDescricao("Skate longboard");
		_skate.setFabricante("Sector 9");
		_skate.setMaterialshape("Bambu");
		_skate.setPreco(999.99f);
		_skate.setTamanhoshape(40.6d);

		System.out.printf("toString() Skate: %s", _skate);
		System.out.println("");

		Bicicleta _bicicleta = new Bicicleta();
		_bicicleta.setCor("Azul");
		_bicicleta.setDescricao("Montain bike");
		_bicicleta.setPreco(458.99f);
		_bicicleta.setTamanhoaro(700);
		_bicicleta.setTamanhoquadro(19);

		System.out.printf("toString() Bicicleta: %s", _bicicleta);
		System.out.println("");

		Bodyboard _bodyboard = new Bodyboard();
		_bodyboard.setBloco("PP");
		_bodyboard.setCor("Preta");
		_bodyboard.setDescricao("Modelo GT 2020");
		_bodyboard.setPreco(999.20f);
		_bodyboard.setTamanho(42.5);

		System.out.printf("toString() Bodyboard: %s", _bodyboard);
		System.out.println("");

		ItemVenda _itemVendaSkate = new ItemVenda();
		_itemVendaSkate.setDescricao("Descricao do Item Venda do Skate");
		_itemVendaSkate.setProduto(_skate);

		ItemVenda _itemVendaBicicleta = new ItemVenda();
		_itemVendaBicicleta.setDescricao("Descricao do Item Venda do Bicicleta");
		_itemVendaBicicleta.setProduto(_bicicleta);

		ItemVenda _itemVendaBodyboard = new ItemVenda();
		_itemVendaBodyboard.setDescricao("Descricao do Item Venda do Bodyboard");
		_itemVendaBodyboard.setProduto(_bodyboard);

		List<ItemVenda> _itensVendidos = new ArrayList<ItemVenda>();
		_itensVendidos.add(_itemVendaSkate);
		_itensVendidos.add(_itemVendaBicicleta);
		_itensVendidos.add(_itemVendaBodyboard);

		_venda.setItensvenda(_itensVendidos);

		serviceVenda.incluir(_venda);

		System.out.println("Venda realizada com sucesso");
	}

	/*
	 * private static void TesteConexao() { if (Conexao.ObterConexao() != null) {
	 * System.out.println("Conexão realizada com sucesso"); } else {
	 * System.out.println("Falha na conexao"); } }
	 */
}