// Author: Evan Scales
// Email: escales@email.sc.edu
// Copyright 2021 Evan Scales
#ifndef FUNCTIONS_H_
#define FUNCTIONS_H_

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <unordered_map>

using std::string;
using std::cout;
using std::cin;
using std::endl;
using std::unordered_map;
using namespace std;


// FUNCTIONS
bool readPackages(string, unordered_map<int, Package>);
void printPackages(const unordered_map<int, Package>);

bool readPackages(string fn, unordered_map<int, Package> pmap) {
    // Read file 
    // 0(Key), Package(1(zipcode), 2(weight), 3(volume), 4(hazmat))
    std::ifstream in(fn);
    string line, token = "";
    if (in.is_open()) {
        while (getline(in, line)) {
            std::stringstream s_line(line);
            vector<int> info;
            int i = 0;
            while (getline(s_line, token, ',')) {
                info[i] = stoi(token);
                i++;
            }
            Package p(info[1], info[2], info[3], info[4]);
            pmap[info[0]] = p;
        }
        return true;
    } else {
        cout << "no file" << endl;
        return false;
    }
    in.close();
}

void printPackages(const unordered_map<int, string> pmap) {
    int i = pmap.begin();
}

#endif  // FUNCTIONS_H_
