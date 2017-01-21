ackage Seconda_parte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
* Classe di collegamente logico tra la seconda parte dell'applicazione e il database 
*/
public class InterazioneDatabaseRis implements AcquisizioneValori
{
	Connection conn = null;
		
	/**
	 * 
	 */
	private void connettiDatabase()
	{
		try 
		{
		    // Caricamento del driver
		    Class.forName("org.postgresql.Driver");
		    
		    // Apertura della connessione
		    this.conn =DriverManager.getConnection("jdbc:postgresql:ASFdb","postgres","postgres86");
		}
		catch (Exception e) 
		{  
			System.out.println(e);System.exit(1); 
		}
	}

	/**
	*
	*/
	public String ottieniInfoCon(int id) 
	{	
			
		try 
		{
			connettiDatabase();
			java.sql.Statement comando =  conn.createStatement();
			
			ResultSet res=comando.executeQuery("select * from configurazioni where id_configurazione="+id);
			res.next();
			
			String dati;
			dati = res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4);
			
			return dati;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
		
	/**
	* 
	*/
	public int numConfDatabase() 
	{
		connettiDatabase();
		java.sql.Statement comando;
		
		try 
		{
			comando = conn.createStatement();
			ResultSet res=comando.executeQuery("select count(id_configurazione) from configurazioni");
			
			res.next();
			
			int num=res.getInt(1);
			
			conn.close();
			
			return num;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	*
	*/
	public ArrayList<String> ottieniParametri(String tipo)
	{
		connettiDatabase();
		java.sql.Statement comando;
		
		try 
		{	
			ArrayList <String> nomiParam = new ArrayList<String>();
			comando = conn.createStatement();
			ResultSet res = null;
			
			res=comando.executeQuery("select nome_parametro from parametri where tipo_parametro='"+tipo+"'");

			while(res.next())
			{
				nomiParam.add(res.getString(1));
			}
			
			return nomiParam;
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	*
	*/		
	public ArrayList<Float> ottieniValoriParam(String nome , int idConf, String forma)
	{
		this.connettiDatabase();
		ArrayList <Float> valori = new ArrayList<Float>();
				
		if(forma.equals("media"))
		{
			try 
			{
				System.out.println(forma);
				java.sql.Statement query =this.conn.createStatement();
				int idParam = this.ottieniIdParam(nome);
				ResultSet res = query.executeQuery("select valore_parametro from mediedatisimulazione where id_configurazione ="+idConf+" and id_parametro="+idParam);
				
				while(res.next())
				{
					valori.add(res.getFloat(1));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
				
		if(forma.equals("min"))
		{
			try 
			{
				java.sql.Statement query =this.conn.createStatement();
				int idParam = this.ottieniIdParam(nome);
				ResultSet res = query.executeQuery("select valore_parametro from mindatisimulazione where id_configurazione ="+idConf+" and id_parametro="+idParam);
				
				while(res.next())
				{
					valori.add(res.getFloat(1));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
				
		if(forma.equals("max"))
		{
			try 
			{
				java.sql.Statement query =this.conn.createStatement();
				int idParam = this.ottieniIdParam(nome);
				ResultSet res = query.executeQuery("select valore_parametro from maxdatisimulazione where id_configurazione ="+idConf+" and id_parametro="+idParam);
					
				while(res.next())
				{
					valori.add(res.getFloat(1));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
				
		if(forma.equals("varianza"))
		{
			try 
			{
				java.sql.Statement query = this.conn.createStatement();
				int idParam = this.ottieniIdParam(nome);
				ResultSet res = query.executeQuery("select valore_parametro from vardatisimulazione where id_configurazione ="+idConf+" and id_parametro="+idParam);
				
				int i=0;
				while(res.next())
				{
					valori.add(res.getFloat(1));
					i++;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if(forma.equals("devStandard"))
		{
			try 
			{
				java.sql.Statement query =this.conn.createStatement();
				int idParam = this.ottieniIdParam(nome);
				ResultSet res = query.executeQuery("select valore_parametro from stdevdatisimulazione where id_configurazione ="+idConf+" and id_parametro="+idParam);
			
				while(res.next())
				{
					valori.add(res.getFloat(1));
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return valori;
	}

	/**
	*
	*/
	public int ottieniIdParam(String nome) throws SQLException
	{
		connettiDatabase();
		
		java.sql.Statement comando = conn.createStatement();
		ResultSet res=comando.executeQuery("select id_parametro from parametri where nome_parametro='"+nome+"'");
		res.next();
		
		return res.getInt(1);
	}

	/**
	*
	*/		
	public ArrayList<Float> ottieniValoriTempo(int idConf)
	{
		connettiDatabase();
		ArrayList <Float> valori = new ArrayList<Float>();
		java.sql.Statement comando;
		try 
		{
			comando = conn.createStatement();
			ResultSet res=comando.executeQuery("select tempo from datisimulazioni,simulazioni where datisimulazioni.id_simulazione=simulazioni.id_simulazione and simulazioni.id_configurazione='"+idConf+"' group by tempo");
			
			while(res.next())
				valori.add(res.getFloat(1));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return valori;
	}
	
	/**
	*
	*/
	public float ottieniValorFunz(String forma,String nomeParam, int idConf)
	{	
		try 
		{	
			connettiDatabase();
			java.sql.Statement comando=conn.createStatement();
			int idParam=this.ottieniIdParam(nomeParam);
			connettiDatabase();
			
			if(forma.equals("media"))
			{
				ResultSet res=comando.executeQuery("select avg(valore_parametro) from mediedatisimulazione where id_parametro="+idParam +" and id_configurazione="+idConf);
				res.next();
				
				return res.getFloat(1);
			}
			
			if(forma.equals("min"))
			{
				ResultSet res=comando.executeQuery("select min(valore_parametro) from mindatisimulazione where id_parametro="+idParam +" and id_configurazione="+idConf);
				res.next();
				return res.getFloat(1);
			}
			
			if(forma.equals("max"))
			{
				ResultSet res=comando.executeQuery("select max(valore_parametro) from maxdatisimulazione where id_parametro="+idParam +" and id_configurazione="+idConf);
				res.next();
				return res.getFloat(1);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
			
	/**
	*
	*/
	public String ottieniValoreConf(String nomeParam,int idConf)
	{
		try 
		{	
			connettiDatabase();
			java.sql.Statement comando=conn.createStatement();
					
			int idParam=this.ottieniIdParam(nomeParam);
			ResultSet res=comando.executeQuery("select valore_parametro from daticonfigurazioni where id_parametro="+idParam+" and id_configurazione="+idConf);
			res.next();
			return res.getString(1);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}			
}
