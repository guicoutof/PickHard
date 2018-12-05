package model;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class Banco {
	String server = "db4free.net";
	String port = "3306";               // Porta TCP padrão do MySQL
	String database = "pickhard";
	String user = "pickhard";
	String passwd = "pickhard";
	
	String url = "jdbc:mysql://" + server + ":" + port + "/" + database;
	
	// Abre-se a conexão com o Banco de Dados
	Connection con = null;
	

	////////////////////
	ArrayList<String> champions = new ArrayList();
	{//if bank not funfe
		
		champions.add("Ahri");
		champions.add("Alistar");
		champions.add("Azir");
		champions.add("Caitlyn");
		champions.add("Cassiopeia");
		champions.add("Bardo");
		champions.add("Diana");
		champions.add("Draven");
		champions.add("Ekko");
		champions.add("Elise");
		champions.add("Fiddlesticks");
		champions.add("Fiora");
		champions.add("Gangplank");
		champions.add("Graves");
		champions.add("Hecarim");
		champions.add("Heimerdinger");
		champions.add("Illaoi");
		champions.add("Ivern");
		champions.add("Jarvan IV");
		champions.add("Jayce");
		champions.add("Jinx");
		champions.add("Kai Sa");
		champions.add("Kalista");
		champions.add("Katarina");
		champions.add("LeBlanc");
		champions.add("Lee Sin");
		champions.add("Malzahar");
		champions.add("Maokai");
		champions.add("Morgana");
		champions.add("Miss Fortune");
		champions.add("Nautilus");
		champions.add("Nami");
		champions.add("Oriana");
		champions.add("Ornn");
		champions.add("Pantheon");
		champions.add("Pyke");
		champions.add("Quinn");
		champions.add("Rakan");
		champions.add("Renekton");
		champions.add("Rengar");
		champions.add("Sion");
		champions.add("Shyvana");
		champions.add("Singed");
		champions.add("Sona");
		champions.add("Tahm Kench");
		champions.add("Talon");
		champions.add("Teemo");
		champions.add("Twisted Fate");
		champions.add("Udyr");
		champions.add("Urgot");
		champions.add("Varus");
		champions.add("Vel Koz");
		champions.add("Volibear");
		champions.add("Wukong");
		champions.add("Warwick");
		champions.add("Xerath");
		champions.add("Yasuo");
		champions.add("Yorick");
		champions.add("Zed");
		champions.add("Zoe");
	}
	
	public Banco() {
		
	}
	

	
	/***
	 * funcao para selecionar os 5 campeões aleatoriamente
	 * @return retorna um array com os 5 campeões escolhidos
	 */
	public ArrayList<String> gerarTime()  {
		
		ArrayList<String> campeoes = new ArrayList<String>();
		ArrayList<Integer> chaveCampeoes = new ArrayList<Integer>();
			try {
				con = DriverManager.getConnection(url, user, passwd);
			Random random = new Random(System.currentTimeMillis());
			chaveCampeoes.add(random.nextInt(142));
			wait(100);
			chaveCampeoes.add(random.nextInt(142));
			wait(100);
			chaveCampeoes.add(random.nextInt(142));
			wait(100);
			chaveCampeoes.add(random.nextInt(142));
			wait(100);
			chaveCampeoes.add(random.nextInt(142));
			
			for(int i=0;i<5;i++) {
				PreparedStatement prepStmt = con.prepareStatement("SELECT Campeao FROM `ChampionLOL` where Chave=?");
				prepStmt.setInt(1,chaveCampeoes.get(i));
				ResultSet rs = prepStmt.executeQuery();
				campeoes.add(rs.getString(0));
			}
			}catch (Exception e) {
				// TODO: handle exception
			}

		return campeoes;
	}
	
	
	/***
	 * Funcao para exibir todos os Campeões cadastrados
	 * @return retorna um array com todos os campeões armazenados
	 */
	public ArrayList<String> exibirCampeoes() {
		ArrayList<String> campeoes = new ArrayList<String>();
		
		try {
			PreparedStatement prepStmt = con.prepareStatement("SELECT Campeao FROM `ChampionLOL`");
			ResultSet rs = prepStmt.executeQuery();
			while(rs.next()) {
				campeoes.add(rs.getString(0));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return campeoes;
	}
	
	/***
	 * Insere um campeão fornecido como parametro
	 * @param nam, nome do campeão que será inserido
	 */
	public void inserirCampeao(String name) {
		try {
			PreparedStatement prepStmt = con.prepareStatement("INSERT INTO `CampeaoLOL` VALUES (? ,?)");
			prepStmt.setString(1,name);
			prepStmt.setString(2,"Nao Classificado");
			ResultSet rs = prepStmt.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/***
	 * Idem a funcao de nome semelhante porem é utilizado como estrutura de armazenamento um array
	 * @return os 5 campeões escolhidos aleatoriamente
	 */
	public ArrayList<String> gerarTimeArray() {
		ArrayList<Integer> chaveCampeoes = new ArrayList<Integer>();
		ArrayList<String> campeoes = new ArrayList<String>();
		
		try {
		
		Random random = new Random(System.currentTimeMillis());
		
		chaveCampeoes.add(random.nextInt(champions.size()));
		//wait(100);
		chaveCampeoes.add(random.nextInt(champions.size()));
		//wait(100);
		chaveCampeoes.add(random.nextInt(champions.size()));
		//wait(100);
		chaveCampeoes.add(random.nextInt(champions.size()));
		//wait(100);
		chaveCampeoes.add(random.nextInt(champions.size()));
		}catch (Exception e) {
			// TODO: handle exception
		}
		for(int i=0;i<5;i++) {
			campeoes.add(champions.get(chaveCampeoes.get(i)));
			//System.out.println(campeoes.get(i));
		}
		return campeoes;
	}
	
	/***
	 * Idem a funcao de nome semelhante porem é utilizado como estrutura de armazenamento um array
	 * @return o array que esta armazenado todos os campeões
	 */
	public ArrayList<String> exibirCampeoesArray() {
		return this.champions;
	}
	
	/***
	 * Idem a funcao de nome semelhante porem é utilizado como estrutura de armazenamento um array
	 * @param name nome do campeão que será inserido
	 */
	public void inserirCampeoesArray(String name) {
		if(!name.isEmpty())
		champions.add(name);
	}
}
