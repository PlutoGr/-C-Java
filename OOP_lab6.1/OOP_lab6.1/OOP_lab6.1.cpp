// OOP_lab6.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <fstream>
#include <iostream>
#include <time.h>
#include <conio.h>

using namespace std;

const int n = 10;

class bin_stream : public fstream
{
public:
	bin_stream(const char *fn) :
		fstream(fn, ios::out | ios::in | ios::binary) {}
	void doneOurDate(const void*, int, int);
	bin_stream &operator<<(int d)
	{
		doneOurDate(&d, sizeof(d), 0);
		return *this;
	}
	bin_stream &operator>>(int &d)
	{
		doneOurDate(&d, sizeof(d), 1);
		return *this;
	}
};

class bin_outstream : public ofstream
{
public:
	bin_outstream(const char *fn) :
		ofstream(fn, ios::out | ios::binary) {}
	void writeOurDate(const void*, int);
	ofstream &operator<<(int d)
	{
		writeOurDate(&d, sizeof(d));
		return *this;
	}
};




int main()
{
	int i, d, m[n],s=0;
	time_t t;
	srand((int)time(&t));

	bin_outstream bin_out1("Bin1.dat"); // создание файла 1
	if (!bin_out1)
	{
		cerr << "Unable to write to Bin.dat" << endl;
		exit(1);
	}
	for (i = 0; i < n; i++)
	{
		d = rand() % 10 - 5;
		if (d == 0) s++;
		m[i] = d;
		bin_out1 << d;
		cout << d << ' ';
	}
	bin_out1.close();

	cout << endl;
////////////////////////////////////////////////////////////////////////////////
	bin_outstream bin_out2("Bin2.dat"); // создание файла 2
	if (!bin_out2)
	{
		cerr << "Unable to write to Bin.dat" << endl;
		exit(1);
	}
	for (i = 0; i < n-1; i++)
		if (m[i+1]!=0) bin_out2 << m[i];
	bin_out2 << m[n - 1];
	bin_out2.close();
/////////////////////////////////////////////////////////////////////////////////
	bin_stream bin("Bin2.dat"); // обработка файла
	if (!bin)
	{
		cerr << "Unable to write to Bin.dat" << endl;
		exit(1);
	}
	/*while (bin)
	{
		bin >> d;
		cout << d << ' ';
	}*/
	for (i=0;i<n-s;i++)
	{
		bin >> d;
		cout << d << ' ';
	}
	bin.close();
	_getch();
	return 0;
}




void bin_stream::doneOurDate(const void *Ptr, int len, int sign)
{
	if (!Ptr)   return;
	if (len <= 0)   return;
	if (sign == 0) write((char*)Ptr, len);
	else  read((char*)Ptr, len);
}


void bin_outstream::writeOurDate(const void *Ptr, int len)
{
	if (!Ptr) return;
	if (len <= 0) return;
	write((char*)Ptr, len);
}
