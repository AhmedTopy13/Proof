using System;
using System.Collections.Generic;
using System.Text;

namespace Showcase.Model
{
    public class Item
    {
        public Guid Id { get; set; } = Guid.NewGuid();
        public string Title { get; set; } = string.Empty;
    }
}
