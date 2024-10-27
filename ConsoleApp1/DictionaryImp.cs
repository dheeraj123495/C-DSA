class DictionaryImp<K,V>{
    Dictionary<K, V> dict = new Dictionary<K,V>();
    public void Add(K key, V val){
        dict.Add(key, val);
    }
    public void Update(K key, V val){
        dict[key] = val;
    }
    public void Accessing(K key){
        Console.WriteLine($"Value for {key} is : " + dict[key]);
    }
    public void Remove(K key){
        Console.WriteLine("Removed value : " + dict.Remove(key));
    }
    public void Display(){
        if(dict.Count > 0){
            foreach (KeyValuePair<K, V> item in dict)
            {
                Console.WriteLine(item.Key + " - " + item.Value);
            }
        }
        else{
            Console.WriteLine("List is empty");
        }
    }

    public void SearchKey(K key){
        if(dict.ContainsKey(key)){
            Console.WriteLine("List contains key : " + key);
        }else{
            Console.WriteLine("List do not contain key : " + key);
        }
    }

    public void SerachValue(V val){
        if (dict.ContainsValue(val))
        {
            Console.WriteLine("List contains value : " + val);
        }
        else
        {
            Console.WriteLine("List do not contain value : " + val);
        }
    }
    public void Clear(){
        dict.Clear();
        Console.WriteLine("Deleted all elements");
    }
}