### Time & Space Complexity
Complexity matching is basically calculating number of operations performed to achieve the same business logic. Makes it independent of machine specifics. It is a good methodology to compare two piece of code. There are three notations : Omega (Best Case), Theta (Average Case), Omicron (Worst Case). We drop constants, ignore less complexity part of code, take the dominant part as the complexity. Use different terms for parameters, don't take O(a + b) as O(n).

![Complexity Chart](./readme-assets/complexity-chart.png)

### Linked List
It is different to the arraylist, since, it does not have contiguous memoryh space, instead, all the nodes are scattered around in the memory & hence, no indexing is possible. A node is like a json, with two keys: "value" & "next_pointer".
```java
// when we set node A pointer towards node B, logically, it means this:
{
    "value": 'A',
    "next": {
        "value": B,
        "next": null
    }
}
```