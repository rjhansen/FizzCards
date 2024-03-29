#include "carddeck.h"
#include <iostream>

using engineering::hansen::Card;
using engineering::hansen::CardDeck;
using std::cout;
using std::endl;

int main()
{
    CardDeck cd;
    while (!cd.empty())
        cout << cd.dealOneCard() << endl;

    return 0;
}