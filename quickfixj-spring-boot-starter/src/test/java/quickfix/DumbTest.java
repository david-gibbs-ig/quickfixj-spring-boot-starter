/*
 * Copyright 2017-2022 the original author or authors.
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
package quickfix;

import java.math.BigDecimal;

import org.junit.Test;

public class DumbTest {


	@Test
	public void aTest() {
		OrderQtyD orderQtyD = new OrderQtyD(1);
		OrderQtyDec orderQtyDec = new OrderQtyDec(1);
	}

	public class OrderQtyD extends DoubleField {

		static final long serialVersionUID = 20050617;
	
		public static final int FIELD = 38;
		
		public OrderQtyD() {
			super(38);
		}
	
		public OrderQtyD(double data) {
			super(38, data);
		}
	}
	
	public class OrderQtyDec extends DecimalFieldIn {

		static final long serialVersionUID = 20050617;
	
		public static final int FIELD = 38;
		
		public OrderQtyDec() {
			super(38);
		}
	
		public OrderQtyDec(double data) {
			super(38, data);
		}
	}
	
	/**
	 * A double-values message field.
	 */
	public class DecimalFieldIn extends Field<BigDecimal> {

	    private int padding = 0;

	    public DecimalFieldIn(int field) {
	        super(field, BigDecimal.ZERO);
	    }

	    public DecimalFieldIn(int field, BigDecimal data) {
	        super(field, data);
	    }

	    public DecimalFieldIn(int field, double data) {
	        super(field, BigDecimal.valueOf(data));
	    }

	    public DecimalFieldIn(int field, BigDecimal data, int padding) {
	        super(field, data);
	        this.padding = padding;
	    }

	    public void setValue(BigDecimal value) {
	        setObject(value);
	    }

	    public void setValue(double value) {
	        setObject(BigDecimal.valueOf(value));
	    }

	    public BigDecimal getValue() {
	        return getObject();
	    }

	    public int getPadding() {
	        return padding;
	    }

	    public boolean valueEquals(BigDecimal value) {
	        return getValue().compareTo(value) == 0;
	    }

	    public boolean valueEquals(double value) {
	        return getValue().compareTo(new BigDecimal(value)) == 0;
	    }
	}
	
}


