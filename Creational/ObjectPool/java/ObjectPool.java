/**
 * for database storage handling, tracking, expiration time
 **/
public abstract class ObjectPool{
    private long expirationTime;
    private Hashtable locked, unlocked;
    abstract Object create();
    abstract boolean validate(Object o);
    abstract void expire(Object o);

    public void ObjectPool(){
        expirationTime = 6666;
        locked = new Hashtable();
        unlocked = new Hashtable();
    }
    public synchronized Object checkOut(){
        long now = System.currentTimeMillis();
        Object o;
        if( unlocked.size() > 0 )
        {
            Enumeration e = unlocked.keys();
            while( e.hasMoreElements() )
            {
                o = e.nextElement();
                if( ( now - ( ( Long ) unlocked.get( o ) ).longValue() ) >
                        expirationTime )
                {
                    // object has expired
                    unlocked.remove( o );
                    expire( o );
                    o = null;
                }
                else
                {
                    if( validate( o ) )
                    {
                        unlocked.remove( o );
                        locked.put( o, new Long( now ) );
                        return( o );
                    }
                    else
                    {
                        // object failed validation
                        unlocked.remove( o );
                        expire( o );
                        o = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        o = create();
        locked.put( o, new Long( now ) );
        return( o );
    }
    public synchronized void checkIn(Object o){
        locked.remove( o );
        unlocked.put( o, new Long( System.currentTimeMillis() ) );
    }
}
