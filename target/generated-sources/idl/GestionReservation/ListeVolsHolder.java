package GestionReservation;

/**
 * Generated from IDL alias "ListeVols".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class ListeVolsHolder
	implements org.omg.CORBA.portable.Streamable
{
	public GestionReservation.Vol[] value;

	public ListeVolsHolder ()
	{
	}
	public ListeVolsHolder (final GestionReservation.Vol[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return ListeVolsHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = ListeVolsHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		ListeVolsHelper.write (out,value);
	}
}
