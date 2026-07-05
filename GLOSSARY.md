# Java Collections Glossary

Terms for Java collections internals in this workspace. Definitions tighten as lessons progress.

## HashMap Terms

**Bucket**:
One slot in the `table` array. An index where entries whose keys hash to the same value may be stored.
_Avoid_: slot, bin (acceptable but prefer bucket in lessons)

**Collision**:
When two different keys produce the same bucket index. Resolved by chaining (linked list or tree), not by rejecting the put.
_Avoid_: duplicate, clash

**Load factor**:
The fraction of capacity allowed to fill before resize. Default `0.75f`. Threshold = capacity × load factor.
_Avoid_: fill ratio

**Rehash / resize**:
When `size > threshold`, capacity doubles and every entry is moved to a new bucket index.
_Avoid_: reindex (use only when describing the algorithm step)

**Spread hash**:
The processed hash stored in each Node: `h ^ (h >>> 16)`. Distributes bits before index calculation.
_Avoid_: final hash, mixed hash

**Treeify**:
Converting a bucket's linked list to a red-black tree when chain length exceeds 8 and table capacity ≥ 64 (Java 8+).
_Avoid_: tree conversion

## ArrayList Terms

**Backing Array**:
The underlying primitive array (`Object[]`) used to store the elements of an `ArrayList`.
_Avoid_: storage array, internal buffer

**Capacity**:
The length of the backing array, representing the maximum number of elements the list can hold before growing.
_Avoid_: limit, max size

**Size**:
The actual number of elements currently stored in the `ArrayList`.
_Avoid_: count, length

**Growth Factor**:
The multiplier (1.5x in JDK) by which the capacity of the backing array is expanded when it becomes full.
_Avoid_: expansion rate, multiplier

**Random Access**:
Retrieving or updating an element at a specific index in constant `O(1)` time.
_Avoid_: direct indexing, direct lookup

