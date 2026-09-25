package GestionReservation;

/**
 * Generated from IDL alias "ListeVols".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public abstract class ListeVolsHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;

	public static void insert (org.omg.CORBA.Any any, GestionReservation.Vol[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static GestionReservation.Vol[] extract (final org.omg.CORBA.Any any)
	{
		if ( any.type().kind() == org.omg.CORBA.TCKind.tk_null)
		{
			throw new org.omg.CORBA.BAD_OPERATION ("Can't extract from Any with null type.");
		}
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(ListeVolsHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_alias_tc(GestionReservation.ListeVolsHelper.id(), "ListeVols",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_struct_tc(GestionReservation.VolHelper.id(),"Vol",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("idVol", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("companie", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("lieuDepart", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("lieuArrivee", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("dateDepart", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("dateArrivee", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("prixBase", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(7)), null)})));
				}
			}
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:GestionReservation/ListeVols:1.0";
	}
	public static GestionReservation.Vol[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		GestionReservation.Vol[] _result;
		int _l_result0 = _in.read_long();
		try
		{
			 int x = _in.available();
			 if ( x > 0 && _l_result0 > x )
				{
					throw new org.omg.CORBA.MARSHAL("Sequence length too large. Only " + x + " available and trying to assign " + _l_result0);
				}
		}
		catch (java.io.IOException e)
		{
		}
		_result = new GestionReservation.Vol[_l_result0];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=GestionReservation.VolHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, GestionReservation.Vol[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			GestionReservation.VolHelper.write(_out,_s[i]);
		}

	}
}
