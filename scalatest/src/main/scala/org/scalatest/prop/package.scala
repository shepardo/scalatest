/*
 * Copyright 2001-2015 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalatest

import org.scalactic.anyvals._
import scala.annotation.tailrec
import scala.reflect.runtime.universe.TypeTag

package object prop {

  /**
   * <strong>Checkers has been moved from org.scalatest.prop to org.scalatest.check. Please update
   * your imports, as this deprecated type alias will be removed in a future version of ScalaTest.</strong>
   */
  @deprecated("Please use org.scalatest.check.Checkers instead.", "ScalaTest 3.1.0")
  type Checkers = org.scalatest.check.Checkers

  /**
   * <strong>Checkers has been moved from org.scalatest.prop to org.scalatest.check. Please update
   * your imports, as this deprecated type alias will be removed in a future version of ScalaTest.</strong>
   */
  @deprecated("Please use org.scalatest.check.Checkers instead.", "ScalaTest 3.1.0")
  val Checkers: org.scalatest.check.Checkers.type = org.scalatest.check.Checkers 

  // The valueOf methods are called by the function generators.
  def valueOf[B](multiplier: Int, a: Any)(implicit genOfB: Generator[B]): B = {
   val seed = a.hashCode.toLong * multiplier
   val rnd = Randomizer(seed)
   val (size, nextRnd) = rnd.chooseInt(1, 20)
   val (result, _, _) = genOfB.next(size, Nil, nextRnd)
   result
  }

  def valueOf[C](multiplier: Int, a: Any, b: Any)(implicit genOfC: Generator[C]): C = {
    def combinedHashCode(a: Any, b: Any): Int = 
      37 * (
        37 + a.hashCode
      ) + b.hashCode
    val seed = combinedHashCode(a, b).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfC.next(size, Nil, nextRnd)
    result
  }

  def valueOf[D](multiplier: Int, a: Any, b: Any, c: Any)(implicit genOfD: Generator[D]): D = {
    def combinedHashCode(a: Any, b: Any, c: Any): Int = 
      37 * (
        37 * (
          37 + a.hashCode
        ) + b.hashCode
      ) + c.hashCode
    val seed = combinedHashCode(a, b, c).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfD.next(size, Nil, nextRnd)
    result
  }

  def valueOf[E](multiplier: Int, a: Any, b: Any, c: Any, d: Any)(implicit genOfE: Generator[E]): E = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 + a.hashCode
          ) + b.hashCode
        ) + c.hashCode
      ) + d.hashCode
    val seed = combinedHashCode(a, b, c, d).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfE.next(size, Nil, nextRnd)
    result
  }

  def valueOf[F](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any)(implicit genOfF: Generator[F]): F = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 + a.hashCode
            ) + b.hashCode
          ) + c.hashCode
        ) + d.hashCode
      ) + e.hashCode
    val seed = combinedHashCode(a, b, c, d, e).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfF.next(size, Nil, nextRnd)
    result
  }

  def valueOf[G](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any)(implicit genOfG: Generator[G]): G = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 + a.hashCode
              ) + b.hashCode
            ) + c.hashCode
          ) + d.hashCode
        ) + e.hashCode
      ) + f.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfG.next(size, Nil, nextRnd)
    result
  }

  def valueOf[H](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any)(implicit genOfH: Generator[H]): H = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 + a.hashCode
                ) + b.hashCode
              ) + c.hashCode
            ) + d.hashCode
          ) + e.hashCode
        ) + f.hashCode
      ) + g.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfH.next(size, Nil, nextRnd)
    result
  }

  def valueOf[I](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any)(implicit genOfI: Generator[I]): I = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 + a.hashCode
                  ) + b.hashCode
                ) + c.hashCode
              ) + d.hashCode
            ) + e.hashCode
          ) + f.hashCode
        ) + g.hashCode
      ) + h.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfI.next(size, Nil, nextRnd)
    result
  }

  def valueOf[J](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any)(implicit genOfJ: Generator[J]): J = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 + a.hashCode
                    ) + b.hashCode
                  ) + c.hashCode
                ) + d.hashCode
              ) + e.hashCode
            ) + f.hashCode
          ) + g.hashCode
        ) + h.hashCode
      ) + i.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfJ.next(size, Nil, nextRnd)
    result
  }

  def valueOf[K](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any)(implicit genOfK: Generator[K]): K = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 + a.hashCode
                      ) + b.hashCode
                    ) + c.hashCode
                  ) + d.hashCode
                ) + e.hashCode
              ) + f.hashCode
            ) + g.hashCode
          ) + h.hashCode
        ) + i.hashCode
      ) + j.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfK.next(size, Nil, nextRnd)
    result
  }

  def valueOf[L](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any)(implicit genOfL: Generator[L]): L = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 + a.hashCode
                        ) + b.hashCode
                      ) + c.hashCode
                    ) + d.hashCode
                  ) + e.hashCode
                ) + f.hashCode
              ) + g.hashCode
            ) + h.hashCode
          ) + i.hashCode
        ) + j.hashCode
      ) + k.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfL.next(size, Nil, nextRnd)
    result
  }

  def valueOf[M](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any)(implicit genOfM: Generator[M]): M = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 + a.hashCode
                          ) + b.hashCode
                        ) + c.hashCode
                      ) + d.hashCode
                    ) + e.hashCode
                  ) + f.hashCode
                ) + g.hashCode
              ) + h.hashCode
            ) + i.hashCode
          ) + j.hashCode
        ) + k.hashCode
      ) + l.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfM.next(size, Nil, nextRnd)
    result
  }

  def valueOf[N](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any)(implicit genOfN: Generator[N]): N = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 + a.hashCode
                            ) + b.hashCode
                          ) + c.hashCode
                        ) + d.hashCode
                      ) + e.hashCode
                    ) + f.hashCode
                  ) + g.hashCode
                ) + h.hashCode
              ) + i.hashCode
            ) + j.hashCode
          ) + k.hashCode
        ) + l.hashCode
      ) + m.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfN.next(size, Nil, nextRnd)
    result
  }

  def valueOf[O](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any)(implicit genOfO: Generator[O]): O = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 + a.hashCode
                              ) + b.hashCode
                            ) + c.hashCode
                          ) + d.hashCode
                        ) + e.hashCode
                      ) + f.hashCode
                    ) + g.hashCode
                  ) + h.hashCode
                ) + i.hashCode
              ) + j.hashCode
            ) + k.hashCode
          ) + l.hashCode
        ) + m.hashCode
      ) + n.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfO.next(size, Nil, nextRnd)
    result
  }

  def valueOf[P](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any)(implicit genOfP: Generator[P]): P = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 + a.hashCode
                                ) + b.hashCode
                              ) + c.hashCode
                            ) + d.hashCode
                          ) + e.hashCode
                        ) + f.hashCode
                      ) + g.hashCode
                    ) + h.hashCode
                  ) + i.hashCode
                ) + j.hashCode
              ) + k.hashCode
            ) + l.hashCode
          ) + m.hashCode
        ) + n.hashCode
      ) + o.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfP.next(size, Nil, nextRnd)
    result
  }

  def valueOf[Q](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any)(implicit genOfQ: Generator[Q]): Q = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 + a.hashCode
                                  ) + b.hashCode
                                ) + c.hashCode
                              ) + d.hashCode
                            ) + e.hashCode
                          ) + f.hashCode
                        ) + g.hashCode
                      ) + h.hashCode
                    ) + i.hashCode
                  ) + j.hashCode
                ) + k.hashCode
              ) + l.hashCode
            ) + m.hashCode
          ) + n.hashCode
        ) + o.hashCode
      ) + p.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfQ.next(size, Nil, nextRnd)
    result
  }

  def valueOf[R](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any)(implicit genOfR: Generator[R]): R = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 + a.hashCode
                                    ) + b.hashCode
                                  ) + c.hashCode
                                ) + d.hashCode
                              ) + e.hashCode
                            ) + f.hashCode
                          ) + g.hashCode
                        ) + h.hashCode
                      ) + i.hashCode
                    ) + j.hashCode
                  ) + k.hashCode
                ) + l.hashCode
              ) + m.hashCode
            ) + n.hashCode
          ) + o.hashCode
        ) + p.hashCode
      ) + q.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfR.next(size, Nil, nextRnd)
    result
  }

  def valueOf[S](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any)(implicit genOfS: Generator[S]): S = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 * (
                                        37 + a.hashCode
                                      ) + b.hashCode
                                    ) + c.hashCode
                                  ) + d.hashCode
                                ) + e.hashCode
                              ) + f.hashCode
                            ) + g.hashCode
                          ) + h.hashCode
                        ) + i.hashCode
                      ) + j.hashCode
                    ) + k.hashCode
                  ) + l.hashCode
                ) + m.hashCode
              ) + n.hashCode
            ) + o.hashCode
          ) + p.hashCode
        ) + q.hashCode
      ) + r.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfS.next(size, Nil, nextRnd)
    result
  }

  def valueOf[T](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any)(implicit genOfT: Generator[T]): T = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 * (
                                        37 * (
                                          37 + a.hashCode
                                        ) + b.hashCode
                                      ) + c.hashCode
                                    ) + d.hashCode
                                  ) + e.hashCode
                                ) + f.hashCode
                              ) + g.hashCode
                            ) + h.hashCode
                          ) + i.hashCode
                        ) + j.hashCode
                      ) + k.hashCode
                    ) + l.hashCode
                  ) + m.hashCode
                ) + n.hashCode
              ) + o.hashCode
            ) + p.hashCode
          ) + q.hashCode
        ) + r.hashCode
      ) + s.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfT.next(size, Nil, nextRnd)
    result
  }

  def valueOf[U](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any)(implicit genOfU: Generator[U]): U = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 * (
                                        37 * (
                                          37 * (
                                            37 + a.hashCode
                                          ) + b.hashCode
                                        ) + c.hashCode
                                      ) + d.hashCode
                                    ) + e.hashCode
                                  ) + f.hashCode
                                ) + g.hashCode
                              ) + h.hashCode
                            ) + i.hashCode
                          ) + j.hashCode
                        ) + k.hashCode
                      ) + l.hashCode
                    ) + m.hashCode
                  ) + n.hashCode
                ) + o.hashCode
              ) + p.hashCode
            ) + q.hashCode
          ) + r.hashCode
        ) + s.hashCode
      ) + t.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfU.next(size, Nil, nextRnd)
    result
  }

  def valueOf[V](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any, u: Any)(implicit genOfV: Generator[V]): V = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any, u: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 * (
                                        37 * (
                                          37 * (
                                            37 * (
                                              37 + a.hashCode
                                            ) + b.hashCode
                                          ) + c.hashCode
                                        ) + d.hashCode
                                      ) + e.hashCode
                                    ) + f.hashCode
                                  ) + g.hashCode
                                ) + h.hashCode
                              ) + i.hashCode
                            ) + j.hashCode
                          ) + k.hashCode
                        ) + l.hashCode
                      ) + m.hashCode
                    ) + n.hashCode
                  ) + o.hashCode
                ) + p.hashCode
              ) + q.hashCode
            ) + r.hashCode
          ) + s.hashCode
        ) + t.hashCode
      ) + u.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfV.next(size, Nil, nextRnd)
    result
  }

  def valueOf[W](multiplier: Int, a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any, u: Any, v: Any)(implicit genOfW: Generator[W]): W = {
    def combinedHashCode(a: Any, b: Any, c: Any, d: Any, e: Any, f: Any, g: Any, h: Any, i: Any, j: Any, k: Any, l: Any, m: Any, n: Any, o: Any, p: Any, q: Any, r: Any, s: Any, t: Any, u: Any, v: Any): Int = 
      37 * (
        37 * (
          37 * (
            37 * (
              37 * (
                37 * (
                  37 * (
                    37 * (
                      37 * (
                        37 * (
                          37 * (
                            37 * (
                              37 * (
                                37 * (
                                  37 * (
                                    37 * (
                                      37 * (
                                        37 * (
                                          37 * (
                                            37 * (
                                              37 * (
                                                37 + a.hashCode
                                              ) + b.hashCode
                                            ) + c.hashCode
                                          ) + d.hashCode
                                        ) + e.hashCode
                                      ) + f.hashCode
                                    ) + g.hashCode
                                  ) + h.hashCode
                                ) + i.hashCode
                              ) + j.hashCode
                            ) + k.hashCode
                          ) + l.hashCode
                        ) + m.hashCode
                      ) + n.hashCode
                    ) + o.hashCode
                  ) + p.hashCode
                ) + q.hashCode
              ) + r.hashCode
            ) + s.hashCode
          ) + t.hashCode
        ) + u.hashCode
      ) + v.hashCode
    val seed = combinedHashCode(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v).toLong * multiplier
    val rnd = Randomizer(seed)
    val (size, nextRnd) = rnd.chooseInt(1, 20)
    val (result, _, _) = genOfW.next(size, Nil, nextRnd)
    result
  }
}
