package GestionReservation;


/**
 * Generated from IDL interface "Booking".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public abstract class BookingHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(BookingHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:GestionReservation/Booking:1.0", "Booking");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final GestionReservation.Booking s)
	{
			any.insert_Object(s);
	}
	public static GestionReservation.Booking extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:GestionReservation/Booking:1.0";
	}
	public static Booking read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(GestionReservation._BookingStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final GestionReservation.Booking s)
	{
		_out.write_Object(s);
	}
	public static GestionReservation.Booking narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof GestionReservation.Booking)
		{
			return (GestionReservation.Booking)obj;
		}
		else if (obj._is_a("IDL:GestionReservation/Booking:1.0"))
		{
			GestionReservation._BookingStub stub;
			stub = new GestionReservation._BookingStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static GestionReservation.Booking unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof GestionReservation.Booking)
		{
			return (GestionReservation.Booking)obj;
		}
		else
		{
			GestionReservation._BookingStub stub;
			stub = new GestionReservation._BookingStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
