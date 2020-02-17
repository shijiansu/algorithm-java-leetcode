package leetcode._3_hard._0126_word_ladder_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 思路: 在v3_1_2的基础上改进, 直接把已经使用过的单词排除在nextWords中, 就不用removeUsedWords的操作了.
 * 改进: 移除removeUsedWords方法
 * 缺点: 暂无.
 */
public class Solution {

  private String endWord;
  private Set<String> wordList;
  // Set<String>的contain操作比List<String>要快
  private Map<String, Set<String>> wordDict;
  private List<List<String>> result;
  private Set<String> usedWords;
  private int wordLength;

  // 用于获得下一个可能的Word, 并且该Word需要在Word List里面
  private Set<String> getNextWordsMagic(String word) {
    // 方法变量比类变量要快
    final char[] letter = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u',
        'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    final int letterLength = 26;
    Set<String> nextWords = new HashSet<String>();
    for (int i = 0; i < wordLength; i++) {
      for (int j = 0; j < letterLength; j++) {
        char[] c = word.toCharArray();
        // 排除当前单词. 以运算换对列表的操作
        if (c[i] != letter[j]) {
          c[i] = letter[j];
          String s = String.valueOf(c);
          // 直接把已经使用过的单词排除在nextWords中, 就不用removeUsedWords的操作了
          if (wordList.contains(s) && !usedWords.contains(s)) {
            nextWords.add(s);
          }
        }
      }
    }
    // System.out.println(": " + word + " -> " + wordStepList);
    return nextWords;
  }

  // 懒加载单词字典
  private void lazySetNextWordsDict(Set<String> currentWords) {
    wordDict.clear();
    // long startTime = System.currentTimeMillis();
    for (String currentWord : currentWords) {
      wordDict.put(currentWord, getNextWordsMagic(currentWord));
    }
    // System.out.println("lazySetNextWordsDict: "
    // + (System.currentTimeMillis() - startTime) + " ms");
  }

  // 递归检查
  private void checkNext(List<List<String>> queue, Set<String> currentWords,
      int queueSize, int lenIndex) {
    // 避免调用queue.size()
    int len = queueSize;
    System.out.println(" Current queue size: " + len);
    queueSize = 0; // reset to get the count of this queue

    // long startTime = System.currentTimeMillis();
    List<List<String>> nextQueue = new ArrayList<List<String>>();
    Set<String> nextCurrentWords = new HashSet<String>();
    int lastIndex = lenIndex - 1;

    // 使用到的时候才获取该次的单词列表, 这里直接不包括usedWords
    lazySetNextWordsDict(currentWords);

    for (int i = 0; i < len; i++) { // forloop faster than foreach
      List<String> q = queue.get(i);
      String currentWord = q.get(lastIndex);

      Set<String> nextWords = wordDict.get(currentWord);
      // System.out.println(" Current word: " + currentWord
      // + ", Current nextWords: " + nextWords);
      // 如果匹配
      if (nextWords.contains(endWord)) {
        // faster than self implemented deepCopy()
        List<String> l = new ArrayList<String>(q);
        l.add(endWord);
        result.add(l);
      } else {
        // 其实一旦找到endWord, 有些单词这里都不用运行, 但是加上一个判读和现在的运算量相当
        Iterator<String> iterator = nextWords.iterator();
        while (iterator.hasNext()) {
          String nw = iterator.next();
          // 前面的共用元素, 不用深复制
          List<String> l = new ArrayList<String>(q);
          l.add(nw);
          nextQueue.add(l);
          // 排除使用过单词
          usedWords.add(nw);
          // 作为下次循环的currentWord
          nextCurrentWords.add(nw);
          // 下次任务加一
          queueSize++;
        }
      }
      // q.clear(); // save memory, but slower
    }
    // queue.clear(); // save memory, but slower
    // 没有任务 , 停止; 已发现最短步长的答案, 停止
    if (queueSize == 0 || result.size() > 0) {
      return;
    } else {
      // System.out.println("  Current cost: "
      // + (System.currentTimeMillis() - startTime));
      // ++lenIndex因为循环次数和queue里面一行的单词数相同
      checkNext(nextQueue, nextCurrentWords, queueSize, ++lenIndex);
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord,
      Set<String> wordList) {
    this.wordLength = beginWord.length();
    this.endWord = endWord;
    this.wordList = wordList;
    this.wordList.add(beginWord);
    this.wordList.add(endWord);

    this.wordDict = new HashMap<String, Set<String>>();
    this.result = new ArrayList<List<String>>();

    List<String> first = new ArrayList<String>();
    first.add(beginWord);
    ArrayList<List<String>> nextQueue = new ArrayList<List<String>>();
    nextQueue.add(first);
    this.usedWords = new HashSet<String>();
    usedWords.add(beginWord);
    Set<String> nextCurrentWords = new HashSet<String>();
    nextCurrentWords.add(beginWord);

    checkNext(nextQueue, nextCurrentWords, 1, 1);
    return result;
  }

  public static void main(String[] args) {
    Test ts = new Test(new Solution());
    ts.testCase1(true);
    ts.testCase2(true);
    ts.testCase3(true);
    ts.testCase4(true);
    ts.testCase5(true);
    ts.testCase6(true);
    ts.testCase7(true);
    ts.testCase8(true);
    ts.testCase9(true);
    ts.testCase10(true);
    ts.testCase11(false);
    ts.printTotalTime();
  }
}
