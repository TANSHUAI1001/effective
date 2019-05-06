package classify;
import net.sf.classifier4J.summariser.SimpleSummariser;

public class Classifier4jCharacterDemo {
    public static void main(String[] args) {
//        String s="被告人:对? 关于王立军,有几个基本事实.首先,1月28日我是初次听到此事.并不相信谷开来会杀人.我跟11·15杀人案无关.我不是谷开来11·15杀人罪的共犯.这个大家都认可.实际上谷开来3月14日她在北京被抓走!" +
//                "在这之前她一直非常确切地跟我说她没杀人,是王立军诬陷她.我在1月28日和次听到这个事时我不相信她会杀人." +
//                "第二个事实,免王立军的局长.是多个因素.一个,我确实认为他诬陷谷开来.但我并不是想掩盖11·15,我是觉得他人品不好." +
//                "因为谷开来和他是如胶似漆,谷开来对他是言听计从,那王立军也通过与谷开来的交往中打入了我的家庭." +
//                "那现在发生这么严重的事.作为一个起码的人,要讲人格的话,你干吗不找谷开来商量,而跑我这里来说这些话?" +
//                "第二个免他的原因,是他想要挟我.他多次谈他身体不好,打黑压力大,得罪了人." +
//                "其实这是在表功.第三,徐某某给我反映了他有五六条问题.有记录.实际上免他是有这些原因的,绝不只是一个谷开来的原因.这是多因一果.";

//        String s = "President Xi Jinping holds a welcoming ceremony for Chilean President Sebastian Pinera in the Great Hall of the People in Beijing on Wednesday. Feng Yongbin/China Daily\n" +
//                "Interconnectivity with Latin American countries high on bilateral talks agenda\n" +
//                "\n" +
//                "China and Chile should connect their development strategies and promote interconnectivity between Chile and other Latin American countries, President Xi Jinping said on Wednesday.\n" +
//                "\n" +
//                "Xi made the remark while meeting with Chilean President Sebastian Pinera in the Great Hall of the People in Beijing. Pinera is on a five-day state visit and planned to attend the Second Belt and Road Forum for International Cooperation. Premier Li Keqiang also met with him on Wednesday.\n" +
//                "\n" +
//                "Xi said Chile is the first South American country to have established diplomatic relations with China, and the first Latin American nation to fully acknowledge China's status as a market-oriented economy.\n" +
//                "\n" +
//                "Xi said that Chile, the first Latin American country to have signed a bilateral free trade agreement with China and to have upgraded the agreement, is an important cooperation partner in jointly building the Belt and Road.\n" +
//                "\n" +
//                "The two countries should take the opportunity to jointly build the Belt and Road, deepen mutual political trust and pragmatic cooperation and promote the development of the China-Chile comprehensive strategic partnership to a higher level, Xi said.\n" +
//                "\n" +
//                "The two countries should promote the upgrading of bilateral trade and investment and enhance cooperation in such areas as minerals, clean energy, information technology, e-commerce, innovation and scientific research on the Antarctic, he said.\n" +
//                "\n" +
//                "Xi called on the two countries to make joint efforts to celebrate the 50th anniversary of China-Chile diplomatic ties next year and promote people-to-people exchanges.\n" +
//                "\n" +
//                "China supports Chile's hosting of the United Nations climate change conference and the Asia-Pacific Economic Cooperation economic leaders' meeting this year, Xi said.\n" +
//                "\n" +
//                "Xi added that the two countries should jointly promote the building of the Asia-Pacific free trade zone and maintain the multilateral trading system.\n" +
//                "\n" +
//                "He said China and Latin American countries should support each other, make full use of their complementary advantages and achieve win-win cooperation. The two sides should pursue common development and jointly build a community with a shared future for China and Latin America, Xi added.\n" +
//                "\n" +
//                "The Chilean president said the Belt and Road Initiative, put forward by Xi, has shown the glorious history of the ancient Silk Road and promoted exchanges between different cultures in the new era.\n" +
//                "\n" +
//                "Chile supports the building of the Belt and Road, and it hopes to learn from China's experience in innovative and green development, he said.\n" +
//                "\n" +
//                "Pinera said Chile, which is dedicated to maintaining multilateralism and the multilateral trading system, would like to enhance coordination with China on regional and multilateral affairs.\n" +
//                "\n" +
//                "With the two presidents as witnesses, China and Chile signed a number of cooperation documents after the talks.\n" +
//                "\n" +
//                "According to Chilean Ambassador Luis Schmidt, the two countries on Wednesday secured a deal to open the Chinese market to Chilean pears.\n" +
//                "\n" +
//                "He said he is expecting the first pear exports to China to take place soon.\n" +
//                "\n" +
//                "Zhou Jin contributed to this story.";

        String s =
                "The United Kingdom has given the green light to Chinese telecom giant Huawei Technologies Co to help build the country's next generation mobile communication technology network, said the Daily Telegraph newspaper.\n" +
                "\n" +
                "The UK's National Security Council, which is chaired by Prime Minister Theresa May, agreed on Tuesday to allow Huawei limited access to help build parts of its 5G network such as antennas and other \"noncore\" infrastructure, the report said, without citing sources.\n" +
                "\n" +
                "Analysts said the news sends a positive signal to Huawei, as entry into the UK's 5G network is highly likely to invite wider recognition in Europe and help reduce security concerns toward the Chinese company.\n" +
                "\n" +
                "Huawei said in an emailed statement to China Daily that it welcomes reports that the UK government is moving toward allowing it in the country's 5G network.\n" +
                "\n" +
                "\"This green light means that UK businesses and consumers will have access to the fastest and most reliable networks thanks to Huawei's cutting-edge technology,\" Huawei said.\n" +
                "\n" +
                "The Shenzhen-based company said it is awaiting a formal government announcement and it is pleased that the UK is continuing to take an evidence-based approach to its work.\n" +
                "\n" +
                "As the world's largest telecom equipment maker and a leading smartphone vendor, Huawei is facing cyber security allegations in some foreign markets, including the United States. The company has repeatedly said such allegations are groundless and not supported by factual evidence.\n" +
                "\n" +
                "The news came after Financial Times reported in February that the UK National Cyber Security Centre had determined that there are ways to limit potential risks from using Huawei in future 5G ultrafast networks.\n" +
                "\n" +
                "Belgian newspaper De Standard also reported earlier that The Center for Cybersecurity Belgium has found no evidence that telecoms equipment supplied by Huawei could be used for spying.\n" +
                "\n" +
                "Xiang Ligang, director-general of the Information Consumption Alliance, said the UK is in a better position than many countries to judge whether Huawei poses security risks, since it has a monitoring body that has been checking the company's products for years.\n" +
                "\n" +
                "\"But it still remains to be seen whether Huawei can be allowed in the UK's core infrastructure for the 5G network,\" Xiang said.\n" +
                "\n" +
                "Despite the ongoing challenges, Huawei said it expects to post double-digit growth in its carrier business unit this year, as the Chinese company believes that global investment into 5G will be value-driven, reliable and generate more growth opportunities.\n" +
                "\n" +
                "Hu Houkun, rotating chairman at Huawei, said last week that it had so far secured 40 commercial 5G network contracts, up from 30 announced in late January, and it has shipped more than 70,000 5G base stations, up from 40,000 announced in late February.\n" +
                "\n" +
                "In the first quarter of this year, it posted 179.7 billion yuan ($26.8 billion) in revenue, representing year-on-year growth of 39 percent.\n" +
                "\n" +
                "The company's first quarter net profit margin stood at about 8 percent, slightly higher than the same period last year.";
        SimpleSummariser sim = new SimpleSummariser();
        String ans = sim.summarise(s, 2);
        System.out.println(ans);
    }
}
