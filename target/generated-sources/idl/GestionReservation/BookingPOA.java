package GestionReservation;


/**
 * Generated from IDL interface "Booking".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public abstract class BookingPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, GestionReservation.BookingOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "getListeVols", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:GestionReservation/Booking:1.0"};
	public GestionReservation.Booking _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		GestionReservation.Booking __r = GestionReservation.BookingHelper.narrow(__o);
		return __r;
	}
	public GestionReservation.Booking _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		GestionReservation.Booking __r = GestionReservation.BookingHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // getListeVols
			{
			try
			{
				_out = handler.createReply();
				GestionReservation.ListeVolsHelper.write(_out,getListeVols());
			}
			catch(GestionReservation.VolIntrouvable _ex0)
			{
				_out = handler.createExceptionReply();
				GestionReservation.VolIntrouvableHelper.write(_out, _ex0);
			}
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
