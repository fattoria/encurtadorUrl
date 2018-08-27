package persistence;

import java.util.ArrayList;
import java.util.List;

import control.EncurtarUrl;
import entity.Url;

public class UrlDao extends Dao{
	
	//Métoda para gravar Url's
	public void create(Url u)throws Exception{
		open();
		stmt = con.prepareStatement("insert into url values(null,?,?)");
		stmt.setString(1, u.getUrl_longa());
		stmt.setString(2, new EncurtarUrl().shortURL(u.getUrl_curta()));
		stmt.execute();
		stmt.close();
		close();
	}
	
	//Método para alterar Url's
	public void update(Url u)throws Exception{
		open();
		stmt = con.prepareStatement("update url set url_longa=?, url_curta=? where id=?");
		stmt.setString(1, u.getUrl_longa());
		stmt.setString(2, u.getUrl_curta());
		stmt.setInt(3, u.getId());
		stmt.execute();
		stmt.close();
		close();
	}
	
	//Método para deletar os registros
	public void delete(Integer id)throws Exception{
		open();
		stmt = con.prepareStatement("delete from url where id=?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		close();
	}
	
	//Método para listar todas as URL's
	public List<Url> findAll()throws Exception{
		open();
		stmt = con.prepareStatement("select * from url");
		rs = stmt.executeQuery();
		List<Url> lista = new ArrayList<Url>();
		while(rs.next()) {
			Url u = new Url();
			u.setId(rs.getInt("id"));
			u.setUrl_longa(rs.getString("url_longa"));
			u.setUrl_curta(rs.getString("url_curta"));
			lista.add(u);
		}
		
		close();
		return lista;	
	}

	//Método para Pesquisa a Url pela id
	public Url findByCode(Integer cod)throws Exception{
		open();
		stmt = con.prepareStatement("select * from url where id=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		Url u = null;
		if(rs.next()) {
			u = new Url();
			u.setId(rs.getInt("id"));
			u.setUrl_longa(rs.getString("url_longa"));
			u.setUrl_curta(rs.getString("url_curta"));
		}
		
		close();
		return u;
	}
	
	
}
