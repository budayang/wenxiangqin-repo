//import com.alibaba.ascp.finance.charge.container.domain.result.ChargeExpressionResultDO;
//ChargeExpressionResultDO resultDO = new ChargeExpressionResultDO();
//        quantity = 0;
//        amount = 0;
//        chargeResultAmount = 0;
//        chargeResultType = "chargeExpense";
//        chargeResultDesc = "正常计费结果";
//        if (单据.单据类型 == "TMALL_GLOBAL_FACTORY") {
//        if (单据.计价方式 == "BILL_PERCENT") {
//        amount = 单据.金额;
//        chargeResultAmount = 单据.金额 * 条款.扣点;
//        } else {
//        chargeResultType = "unmatchExpression";
//        chargeResultDesc = "数据有误，未匹配到计费公式";
//        }
//        } else if (单据.单据类型 == "TMALL_GLOBAL_FREE_GOODS" || 单据.单据类型 == "TMALL_GLOBAL_NON_CROSS_BORDER" || 单据.单据类型 == "TMALL_GLOBAL_CPFR") {
//        if (单据.计价方式 == "YEAR_FIXED") {
//        amount = 单据.单价 * 单据.服务生效月数;
//        chargeResultAmount = amount;
//        } else if (单据.计价方式 == "MONTH_FIXED") {
//        amount = 单据.单价 * 单据.服务生效月数;
//        chargeResultAmount = amount;
//        } else {
//        chargeResultType = "unmatchExpression";
//        chargeResultDesc = "数据有误，未匹配到计费公式";
//        }
//        } else if (单据.单据类型 == "TMALL_GLOBAL_GIFT_BOX") {
//        if (单据.计价方式 == "PIECE_FIXED") {
//        amount = 单据.实际生产数量 * 单据.单价;
//        chargeResultAmount = amount;
//        } else {
//        chargeResultType = "unmatchExpression";
//        chargeResultDesc = "数据有误，未匹配到计费公式";
//        }
//        } else {
//        chargeResultType = "unmatchExpression";
//        chargeResultDesc = "数据有误，未匹配到单据类型";
//        }