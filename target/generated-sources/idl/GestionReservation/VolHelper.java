package GestionReservation;


/**
 * Generated from IDL struct "Vol".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public abstract class VolHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(VolHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_struct_tc(GestionReservation.VolHelper.id(),"Vol",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("idVol", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("companie", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("lieuDepart", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("lieuArrivee", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("dateDepart", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("dateArrivee", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("prixBase", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7)), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final GestionReservation.Vol s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static GestionReservation.Vol extract (final org.omg.CORBA.Any any)
	{
		org.omg.CORBA.portable.InputStream in = any.create_input_stream();
		try
		{
			return read (in);
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (java.io.IOException e)
			{
			throw new RuntimeException("Unexpected exception " + e.toString() );
			}
		}
	}

	public static String id()
	{
		return "IDL:GestionReservation/Vol:1.0";
	}
	public static GestionReservation.Vol read (final org.omg.CORBA.portable.InputStream in)
	{
		GestionReservation.Vol result = new GestionReservation.Vol();
		result.idVol=in.read_string();
		result.companie=in.read_string();
		result.lieuDepart=in.read_string();
		result.lieuArrivee=in.read_string();
		result.dateDepart=in.read_string();
		result.dateArrivee=in.read_string();
		result.prixBase=in.read_double();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final GestionReservation.Vol s)
	{
		java.lang.String tmpResult1 = s.idVol;
out.write_string( tmpResult1 );
		java.lang.String tmpResult2 = s.companie;
out.write_string( tmpResult2 );
		java.lang.String tmpResult3 = s.lieuDepart;
out.write_string( tmpResult3 );
		java.lang.String tmpResult4 = s.lieuArrivee;
out.write_string( tmpResult4 );
		java.lang.String tmpResult5 = s.dateDepart;
out.write_string( tmpResult5 );
		java.lang.String tmpResult6 = s.dateArrivee;
out.write_string( tmpResult6 );
		out.write_double(s.prixBase);
	}
}
