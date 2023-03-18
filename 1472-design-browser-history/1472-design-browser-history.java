class BrowserHistory {
    HistoryNode currSite;
    public BrowserHistory(String homepage) {
        currSite = new HistoryNode(homepage);
    }
    
    public void visit(String url) {
        currSite.next = new HistoryNode(url);
        currSite.next.prev = currSite;
        currSite = currSite.next;
    }
    
    public String back(int steps) {
        while(steps > 0 && currSite.prev != null) {
            steps--;
            currSite = currSite.prev;
        }
        return currSite.name;
    }
    
    public String forward(int steps) {
        while(steps > 0 && currSite.next != null) {
            steps--;
            currSite = currSite.next;
        }
        return currSite.name;
    }
}
class HistoryNode {
    String name;
    HistoryNode next;
    HistoryNode prev;
    HistoryNode(String name) {
        this.name = name;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */