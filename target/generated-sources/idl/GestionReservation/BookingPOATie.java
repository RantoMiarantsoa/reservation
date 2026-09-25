package GestionReservation;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Booking".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public class BookingPOATie
	extends BookingPOA
{
	private BookingOperations _delegate;

	private POA _poa;
	public BookingPOATie(BookingOperations delegate)
	{
		_delegate = delegate;
	}
	public BookingPOATie(BookingOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public BookingOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(BookingOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public GestionReservation.Vol[] getListeVols() throws GestionReservation.VolIntrouvable
	{
		return _delegate.getListeVols();
	}

}
