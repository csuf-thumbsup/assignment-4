#include <iostream>
#include <iomanip>
#include <string>
#include <unordered_map>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(const string &s, char delim) {
	vector<string> elems;
	stringstream ss;
	string item;
	ss.str(s);
	while (getline(ss, item, delim))
		elems.push_back(item);
	return elems;
}

bool is_number(const string &token)
{
	for (string::const_iterator x = token.begin(); x != token.end(); x++)
		if (!isdigit(*x)) return false;
	return true;
}

bool is_reserved_word(const string &token)
{
	string reserved_words[] = {"cout<<", "for", "int", "while"};

	for (string reserved_word : reserved_words)
		if (token == reserved_word) return true;
	return false;
}

bool is_special_symbol(const string &token)
{
	string special_symbols[] = {"=", "*", "-", ";", "(", ")", "<="};

	for (string special_symbol : special_symbols)
		if (token == special_symbol) return true;
	return false;
}

bool is_identifier(const string &token)
{
	if (isdigit(token[0])) return false;
	return true;
}

void process_statement(vector<string> arr)
{
	for (string token : arr)
	{
		if (is_number(token))
		{
			cout << setw(15) << left << token << "number" << endl;
		}
		else if (is_reserved_word(token))
		{
			cout << setw(15) << left << token << "reserved word" << endl;
		}
		else if (is_special_symbol(token))
		{
			cout << setw(15) << left << token << "special symbol" << endl;
		}
		else if (is_identifier(token))
		{
			cout << setw(15) << left << token << "identifier" << endl;
		}
		else 
		{
			cout << setw(15) << left << token << "not identifier" << endl;
		}
	}

}

int main()
{
	char choice = 'y';
	string statement;

	while (choice == 'y')
	{
		cout << "\nEnter a statement: ";
		getline(cin, statement);
		process_statement(split(statement, ' '));

		cout << "CONTINUE (y/n)?";
		cin >> choice;
		choice = tolower(choice);
		cin.ignore(1); // ignore newline
	}
}