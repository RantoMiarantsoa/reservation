package GestionReservation;


/**
 * Generated from IDL exception "VolIntrouvable".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public abstract class VolIntrouvableHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(VolIntrouvableHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_exception_tc(GestionReservation.VolIntrouvableHelper.id(),"VolIntrouvable",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("volId", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final GestionReservation.VolIntrouvable s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static GestionReservation.VolIntrouvable extract (final org.omg.CORBA.Any any)
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
		return "IDL:GestionReservation/VolIntrouvable:1.0";
	}
	public static GestionReservation.VolIntrouvable read (final org.omg.CORBA.portable.InputStream in)
	{
		String id = in.read_string();
		if (!id.equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
		java.lang.String x0;
		x0=in.read_string();
		final GestionReservation.VolIntrouvable result = new GestionReservation.VolIntrouvable(id, x0);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final GestionReservation.VolIntrouvable s)
	{
		out.write_string(id());
		java.lang.String tmpResult0 = s.volId;
out.write_string( tmpResult0 );
	}
}
