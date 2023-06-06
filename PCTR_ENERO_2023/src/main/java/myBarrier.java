/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

import java.util.concurrent.locks.*;

public class myBarrier {
    private int _nThreads, _currentThreads;
    
    private final Lock _lock;
    private final Condition _barrier;
    
    public myBarrier(int nThreads){
        this._nThreads = nThreads;
        this._currentThreads = nThreads;
        
        this._lock = new ReentrantLock();
        this._barrier = _lock.newCondition();
    }
    
    public void toWaitOnBarrier() throws InterruptedException{
        _lock.lock();
        _currentThreads--;
        if(_currentThreads > 0){
            _barrier.await();
        }else{
            _barrier.notifyAll();
            _currentThreads = _nThreads;
        }
        _lock.unlock();
    }
    
    public void resetBarrier(){
        _lock.lock();
        _barrier.notifyAll();
        _currentThreads = _nThreads;
        _lock.unlock();
    }
}
