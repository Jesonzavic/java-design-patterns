/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iluwatar.effectivity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Employment denotes an employment with a given company over some date range.
 */
@Getter
@Setter
@ToString(includeFieldNames = false)
public class Employment {
  private DateRange effective;
  private Company company;

  Employment(Company company, DateRange effective) {
    this.company = company;
    this.effective = effective;
  }

  /**
   * Checks if the current employment is effective on the given date.
   *
   * @param arg Date to check if effective on.
   * @return True if the employment is effective on the given date.
   */
  public boolean isEffectiveOn(SimpleDate arg) {
    return effective.includes(arg);
  }

  /**
   * Sets the end of the current employments effectiveness to the give date.
   *
   * @param endDate Date this employment should no longer be effective on.
   */
  public void setEnd(SimpleDate endDate) {
    effective = new DateRange(effective.getStartDate(), endDate);
  }
}
