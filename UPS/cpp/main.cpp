// Copyright 2021 Evan Scales
#include <iostream>
#include "./functions.h"
#include <unordered_map>
#include <vector>
#include <iterator>

using std::cout;
using std::endl;
using std::unordered_map;

// Package class start
class Package {
 public:
    explicit Package(int nZ, int nW, int nV, bool nH) {
        zipcode = nZ;
        weight = nW;
        volume = nV;
        hazmat = nH;
    }

 protected:

 private:
    int zipcode;
    int weight;
    int volume;
    bool hazmat;
};
// Pack cklass end

int main(int argc, char const *argv[])
{

    unordered_map<int, Package> pmap;
    cout << "Hello again please upload your data" << endl;
    string fn = "";
    cin >> fn;
    bool succes = readPackages(fn, pmap);
    printPackages(pmap);

    return 0;
}
