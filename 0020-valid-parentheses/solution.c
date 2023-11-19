bool isValid(char *s) {
    int MAX_SIZE = 10000;
    char stack[MAX_SIZE];
    int top = -1;
    char brackets_map[128];

    brackets_map[')'] = '(';
    brackets_map['}'] = '{';
    brackets_map[']'] = '[';

    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stack[++top] = s[i];
        } else if (s[i] == ')' || s[i] == '}' || s[i] == ']') {
            if (top == -1 || brackets_map[s[i]] != stack[top]) {
                return false;
            }
            top--;
        } else {
            return false;
        }
    }

    return top == -1;
}
