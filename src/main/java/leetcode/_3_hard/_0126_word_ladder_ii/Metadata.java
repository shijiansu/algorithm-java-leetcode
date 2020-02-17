package leetcode._3_hard._0126_word_ladder_ii;

/* 名词解释: 
 * - Step: 单词演变的每一步.
 * - nextWord: 下一单词, 单词演变的下一个单词.
 * - nextWords: 单词演变的下一个所有单词. 所有Word+nextWords组成了Word Dictionary
 * - beginWord: 开始单词, 类似"hit".
 * - endWord: 结束单词, 类似"cog".
 * - word: 某个单词.例如 "hot".
 * - currentWord: 当前单词, 当前所在处理的单词. beginWord是第一个currentWord.
 * - Word Set: 例如["hot", "dot", "dog", "lot", "log"]. Set形式.
 * - Word List: 例如["hot", "dot", "dog", "lot", "log"]. List形式.
 * - Word Dictionary: 所有被提供的Word及其nextWords.
 * - usedWord: 使用过单词. 已经出现在之前. 使用过单词不应该再出现nextWords, 作为答案.
 * - Graph: 可能性的答案的图, 包括所有可能的答案, 里面每个元素包括各个Step.
 * - Answer: 该问题的答案.
 * - queue: 任务队列, 每一个元素对应一个可能匹配的运算.
 * - nextQueue: 下一个任务队列, 用于下一个checkNext的运算.
 * - wordLength: 单词的长度, 全部单词长度一致.
 */
public class Metadata {
}
