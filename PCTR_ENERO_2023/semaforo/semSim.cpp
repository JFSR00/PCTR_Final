/**
 *
 * Autor: Juan Francisco Santos Relinque
 */

#include <iostream>
#include <thread>

#include <mutex>
#include <condition_variable>


class Semaphore{
public:
	Semaphore(unsigned int n): _n(n){};

	void waitSim(){
		std::unique_lock<std::mutex> lck(_lock);
		while(_n == 0){
			_semaphore.wait(lck);
		}

		if(_n > 0){
			_n--;
		}
	};

	void signalSim(){
		std::unique_lock<std::mutex> lck(_lock);
		_n++;
		_semaphore.notify_all();
	};

private:
	std::mutex _lock;
	std::condition_variable _semaphore;
	unsigned int _n;
};


using namespace std;

Semaphore sem(1);

int cont = 0;

void incCont(){
	sem.waitSim();
	for(int i=0; i<400000; i++)
		cont++;
	sem.signalSim();
}

void decCont(){
	sem.waitSim();
	for(int i=0; i<400000; i++)
		cont--;
	sem.signalSim();
}

int main(){
	cout<<"main creando semaforo y hebras concurrentes..."<<endl;
	thread hilo0(incCont), hilo1(incCont), hilo2(decCont), hilo3(decCont);

	cout<<"hebras procesando..."<<endl;

	hilo0.join();
	hilo1.join();
	hilo2.join();
	hilo3.join();

	cout<<"main mostrando valor final del contador compartido: "<<cont<<endl;

	return 0;
}
